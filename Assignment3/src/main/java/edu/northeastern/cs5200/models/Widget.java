package edu.northeastern.cs5200.models;


public class Widget {

  // Data storage for Widget table.
  private int id;
  private String name;
  private int width;
  private int height;
  private String cssClass;
  private String cssStyle;
  private String text;
  private int order;
  private DType dType;
  private int size;
  private String html;
  private String src;
  private String url;
  private boolean sharable;
  private boolean expandable;


  // foreign key.
  public Page pageId;

  public Widget(int id, String name, int width, int height, String cssClass, String cssStyle,
                String text, int order) {
    super();

    this.id = id;
    this.name = name;
    this.width = width;
    this.height = height;
    this.cssClass = cssClass;
    this.cssStyle = cssStyle;
    this.text = text;
    this.order = order;

  }

  public Widget(int id, String name, int width, int height, String cssClass, String cssStyle,
                String text, int order, int size, String html, String src, String url,
                boolean sharable, boolean expandable, DType dType) {
    super();

    this.id = id;
    this.name = name;
    this.width = width;
    this.height = height;
    this.cssClass = cssClass;
    this.cssStyle = cssStyle;
    this.text = text;
    this.order = order;
    this.dType = dType;
    this.size = size;
    this.html = html;
    this.src = src;
    this.url = url;
    this.sharable = sharable;
    this.expandable = expandable;
  }

  // Setters and Getters.

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public String getCssClass() {
    return cssClass;
  }

  public void setCssClass(String cssClass) {
    this.cssClass = cssClass;
  }

  public String getCssStyle() {
    return cssStyle;
  }

  public void setCssStyle(String cssStyle) {
    this.cssStyle = cssStyle;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public int getOrder() {
    return order;
  }

  public void setOrder(int order) {
    this.order = order;
  }

  public DType getdType() {
    return dType;
  }

  public void setdType(DType dType) {
    this.dType = dType;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  public String getHtml() {
    return html;
  }

  public void setHtml(String html) {
    this.html = html;
  }

  public String getSrc() {
    return src;
  }

  public void setSrc(String src) {
    this.src = src;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public boolean isSharable() {
    return sharable;
  }

  public void setSharable(boolean sharable) {
    this.sharable = sharable;
  }

  public boolean isExpandable() {
    return expandable;
  }

  public void setExpandable(boolean expandable) {
    this.expandable = expandable;
  }

  public Page getPageId() {
    return pageId;
  }

  public void setPageId(Page pageId) {
    this.pageId = pageId;
  }

  @Override
  public String toString() {
    return this.id + " " + this.name + " " + this.width + " " + this.height + " " + this.cssClass
            +  " " + this.cssStyle +  " " + this.text +  " " + this.order + " " + this.url +
            " " + this.isSharable() +  " " + this.isExpandable() +  " " + this.src +
            " " + this.size + " " + this.html + " " + this.pageId.getId() + " " + this.dType;
  }

}
