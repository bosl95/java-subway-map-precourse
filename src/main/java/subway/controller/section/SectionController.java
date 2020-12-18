package subway.controller.section;

import subway.controller.Controller;
import subway.domain.menu.SectionMenu;
import subway.view.InputView;
import subway.view.SectionOutputView;

public class SectionController implements Controller {
    SectionOutputView sectionOutputView;
    SectionFunction sectionFunction;
    SectionMenu sectionMenu;

    public SectionController() {
        sectionOutputView = new SectionOutputView();
        sectionFunction = new SectionFunction();
    }

    @Override
    public void run() {
        sectionOutputView.printSectionMenu(SectionMenu.list());
        sectionMenu = SectionMenu.findMenu(inputSectionMenu());
        sectionMenu.run();
    }

    private String inputSectionMenu() {
        try {
            sectionOutputView.selectMenu();
            String menu = InputView.selectMenu();
            return menu;
        } catch (NullPointerException e) {
            return inputSectionMenu();
        }
    }

    public static void register() {
        System.out.println("register");
    }

    public static void delete() {
        System.out.println("delete");
    }
}
