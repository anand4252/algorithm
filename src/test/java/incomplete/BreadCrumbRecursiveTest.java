package incomplete;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BreadCrumbRecursiveTest {


    private static BreadcrumbService breadcrumbService;

    @BeforeEach
    void setup() {
        Category rootCategory =
                new Category("bestbuy.ca",
                        new Category("tv",
                                new Category("smart",
                                        new Category("50 inch"),
                                        new Category("60 inch"),
                                        new Category("70 inch")),
                                new Category("oled")),
                        new Category("computer",
                                new Category("laptop",
                                        new Category("apple"),
                                        new Category("pc")),
                                new Category("desktop",
                                        new Category("gaming"),
                                        new Category("workstation"))));
        breadcrumbService = new BreadcrumbService(rootCategory);
    }

    @Test
    public void check_root_element_scenario() {
        final List<Category> breadCrumb = breadcrumbService
                .generateBreadcrumb(new Category("bestbuy.ca"));
        System.out.println(breadCrumb);
        assertTrue(breadCrumb.contains(new Category("bestbuy.ca")));
        assertEquals(1, breadCrumb.size());
    }

    @Test
    public void check_one_level_down_element_scenario() {
        final List<Category> breadCrumb = breadcrumbService
                .generateBreadcrumb(new Category("tv"));
        assertEquals(2, breadCrumb.size());
        assertEquals(new Category("bestbuy.ca"), breadCrumb.get(0));
        assertEquals(new Category("tv"), breadCrumb.get(1));

        System.out.println(breadCrumb);
    }

    @Test
    public void check_two_level_down_element_scenario() {
        final List<Category> breadCrumb = breadcrumbService
                .generateBreadcrumb(new Category("smart"));
        assertEquals(3, breadCrumb.size());
        assertEquals(new Category("bestbuy.ca"), breadCrumb.get(0));
        assertEquals(new Category("tv"), breadCrumb.get(1));
        assertEquals(new Category("smart"), breadCrumb.get(2));
    }

    @Test
    public void check_three_level_down_element_scenario() {
        final List<Category> breadCrumb = breadcrumbService
                .generateBreadcrumb(new Category("50 inch"));
        System.out.println(breadCrumb);
        assertEquals(4, breadCrumb.size());
        assertEquals(new Category("bestbuy.ca"), breadCrumb.get(0));
        assertEquals(new Category("tv"), breadCrumb.get(1));
        assertEquals(new Category("smart"), breadCrumb.get(2));
        assertEquals(new Category("50 inch"), breadCrumb.get(3));
        System.out.println(breadCrumb);
    }


    @Test
    public void check_three_level_down_element_and_middle_sibling_scenario() {
        final List<Category> breadCrumb = breadcrumbService
                .generateBreadcrumb(new Category("60 inch"));
        System.out.println(breadCrumb);
        assertEquals(4, breadCrumb.size());
        assertEquals(new Category("bestbuy.ca"), breadCrumb.get(0));
        assertEquals(new Category("tv"), breadCrumb.get(1));
        assertEquals(new Category("smart"), breadCrumb.get(2));
        assertEquals(new Category("60 inch"), breadCrumb.get(3));
        System.out.println(breadCrumb);
    }

    @Test
    public void check_three_level_down_element_and_last_sibling_scenario() {
        final List<Category> breadCrumb = breadcrumbService
                .generateBreadcrumb(new Category("70 inch"));
        System.out.println(breadCrumb);
        assertEquals(4, breadCrumb.size());
        assertEquals(new Category("bestbuy.ca"), breadCrumb.get(0));
        assertEquals(new Category("tv"), breadCrumb.get(1));
        assertEquals(new Category("smart"), breadCrumb.get(2));
        assertEquals(new Category("70 inch"), breadCrumb.get(3));
        System.out.println(breadCrumb);
    }

    @Test
    public void check_two_level_down_and_sibling_element_scenario() {
        final List<Category> breadCrumb = breadcrumbService
                .generateBreadcrumb(new Category("oled"));
        assertEquals(3, breadCrumb.size());
        assertEquals(new Category("bestbuy.ca"), breadCrumb.get(0));
        assertEquals(new Category("tv"), breadCrumb.get(1));
        assertEquals(new Category("oled"), breadCrumb.get(2));
        System.out.println(breadCrumb);
    }

    @Test
    public void check_one_level_down_and_sibling_element_scenario() {
        final List<Category> breadCrumb = breadcrumbService
                .generateBreadcrumb(new Category("computer"));
        System.out.println(breadCrumb);
        assertEquals(2, breadCrumb.size());
        assertEquals(new Category("bestbuy.ca"), breadCrumb.get(0));
        assertEquals(new Category("computer"), breadCrumb.get(1));
    }
}
