package by.grsu.solomenskay.web.page.horse;

import by.grsu.solomenskay.dataaccess.impl.HorseDao;
import by.grsu.solomenskay.datamodel.Horse;
import by.grsu.solomenskay.web.page.AbstractPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;

import java.util.List;

public class HorsePage extends AbstractPage {
    private final transient HorseDao dao;

    public HorsePage() {
        this.dao = new HorseDao("target/data/");
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        final List<Horse> horses = dao.getAll();
        add(new ListView<Horse>("horse", horses) {
            @Override
            protected void populateItem(ListItem<Horse> item) {
                final Horse horse = item.getModelObject();
                item.add(new Label("id", horse.getId()));
                item.add(new Label("name", horse.getName()));
                item.add(new Label("age", horse.getAge()));
                item.add(new Label("breed", horse.getBreed()));
            }
        });
    }
}
