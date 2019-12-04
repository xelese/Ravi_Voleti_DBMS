package edu.northeastern.cs5200.daos;

import org.junit.Test;

import edu.northeastern.cs5200.models.DType;
import edu.northeastern.cs5200.models.Widget;

import static org.junit.Assert.*;

public class WidgetDaoTest {

  @Test
  public void createWidgetForPage() {
    WidgetImpl widget = new WidgetDao();

    Widget w = new Widget(1,"abc",0,0,null,null,
            "text",0,0,"html","src","url", false,
            false, DType.heading);

    widget.createWidgetForPage(1,w);
  }

  @Test
  public void findAllWidgets() {

    WidgetImpl widget = new WidgetDao();

    System.out.println(widget.findAllWidgets());

  }

  @Test
  public void findWidgetById() {

    WidgetImpl widget = new WidgetDao();

    System.out.println(widget.findWidgetById(1));

  }

  @Test
  public void findWidgetsForPage() {

    WidgetImpl widget = new WidgetDao();

    System.out.println(widget.findWidgetsForPage(2));

  }

  @Test
  public void updateWidget() {

    WidgetImpl widget = new WidgetDao();

    Widget w = new Widget(1,"abc",10,10,null,null,
            "text",0,0,"html","src","url", false,
            false, DType.image);

    widget.updateWidget(1, w);

  }

  @Test
  public void deleteWidget() {

    WidgetImpl widget = new WidgetDao();

    widget.deleteWidget(1);
  }

  @Test
  public void widgetTest() {

    WidgetImpl widgetDao = new WidgetDao();

    Widget widgetUpdateOrder1 = new Widget(3, "head345", 0, 0,
            null, null, "Hi", 3, 0, null, null,
            null, false, false, DType.heading);

    widgetDao.updateWidget(3, widgetUpdateOrder1);
  }
}