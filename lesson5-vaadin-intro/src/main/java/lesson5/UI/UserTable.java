package lesson5.UI;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;
import lesson5.Model.User;
import lesson5.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.viritin.grid.MGrid;
import org.vaadin.viritin.layouts.MVerticalLayout;


/**
 * Вывод данных о пользователях в таблицу
 */
@SpringUI(path = "/users")
public class UserTable extends UI {

    @Autowired
    UserRepository userRepository;

    @Override
    protected void init(VaadinRequest request) {
        MVerticalLayout verticalLayout = new MVerticalLayout();

        MGrid<User> table = new MGrid<>(User.class);

        table.setRows(userRepository.findAll());

        table.withProperties("id", "name");

        verticalLayout.add(table);
        setContent(verticalLayout);
    }
}
