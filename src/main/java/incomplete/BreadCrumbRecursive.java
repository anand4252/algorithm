package incomplete;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class BreadCrumbRecursive {

  public static void main(String[] args) {

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

    BreadcrumbService breadcrumbService = new BreadcrumbService(rootCategory);
    List<Category> breadcrumb = breadcrumbService.generateBreadcrumb(new Category("bestbuy.ca"));
    for (Category category : breadcrumb) {
      System.out.print(category.getName() + " :: ");
    }
  }
}

class BreadcrumbService {

  private final Category root;

  public BreadcrumbService(Category root) {
    this.root = root;
  }

  List<Category> list = new ArrayList<>();

  public List<Category> generateBreadcrumb(Category target) {
    generateBreadcrumbRecursively(root, target);

    return list;
  }

  public void generateBreadcrumbRecursively(Category current, Category target) {
    if(list.contains(target)){
      return;
    }
    if (current.equals(target)) {
      list.add(current);
    } else {
      list.add(current);
      final Set<Category> subCategories = current.getSubCategories();
      for (Category category : subCategories) {
        if(category.equals(target)){
          list.add(category);
          break;
        }
        if (category.getSubCategories() != null && category.getSubCategories().size() > 0) {
          generateBreadcrumbRecursively(category, target);
        }
      }
    }
  }

}


class Category {

  private String name;
  private Set<Category> subCategories;

  public Category(String name, Category... subCategories) {
    this.name = name;
    this.subCategories = new HashSet<>(Arrays.asList(subCategories));
  }


  public String getName() {
    return name;
  }

  public Set<Category> getSubCategories() {
    return subCategories;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof Category)) {
      return false;
    }
    return ((Category) o).getName().equals(this.name);
  }

  @Override
  public int hashCode() {
    return name.hashCode();
  }

  @Override
  public String toString() {
    return "incomplete.Category{" +
        "name='" + name + '\'' +
        '}';
  }
}