package com.example.test;

import com.example.test.service.StorageServise;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.NativeLabel;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.Route;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
/** Основная логика чата */
@Route("")
public class MainView extends VerticalLayout {
    private Storage storage;
    private StorageServise servise;
    DataNumber dataNumber;
    private  Grid<Storage.ChatMessage> grid;

    public MainView(Storage storage) {
        this.storage = storage;

        grid = new Grid<>();
        grid.setItems((DataProvider<Storage.ChatMessage, Void>) storage.getMessages());
        grid.addColumn(new ComponentRenderer<>(message -> new Html(renderRow(message))))
                .setAutoWidth(true);
        TextField field = new TextField();
        add(new H3("Vaadin chat"),grid,
                new HorizontalLayout(){{
                    add(field,
                            new Button("Send message") {{
                                addClickListener(
                                        click -> {
                                            servise.addStorage( field.getValue(),false);
                                            field.clear();
                                        });
                                addClickShortcut(Key.ENTER);
                            }},
                    new Button("+") {{
                        addClickListener(
                                click -> {
                                    servise.addStorage( field.getValue(),true);
                                    field.clear();
                                });
                    }}
                    );
                }}
        );
    }
    private static String renderRow(Storage.ChatMessage message) {
        Parser parser = Parser.builder().build();
        Node document = parser.parse(String.format(message.getMessage()));
        HtmlRenderer htmlRenderer = HtmlRenderer.builder().build();
        return htmlRenderer.render(document);
    }
}
