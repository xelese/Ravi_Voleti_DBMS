package edu.northeastern.cs5200;

import edu.northeastern.cs5200.daos.CreateTableDao;
import edu.northeastern.cs5200.daos.CreateTableImpl;
import edu.northeastern.cs5200.daos.DeveloperDao;
import edu.northeastern.cs5200.daos.DeveloperImpl;
import edu.northeastern.cs5200.daos.PageDao;
import edu.northeastern.cs5200.daos.PageImpl;
import edu.northeastern.cs5200.daos.PriviledgeDao;
import edu.northeastern.cs5200.daos.PriviledgeImpl;
import edu.northeastern.cs5200.daos.RoleDao;
import edu.northeastern.cs5200.daos.RoleImpl;
import edu.northeastern.cs5200.daos.UserDao;
import edu.northeastern.cs5200.daos.UserImpl;
import edu.northeastern.cs5200.daos.WebsiteDao;
import edu.northeastern.cs5200.daos.WebsiteImpl;
import edu.northeastern.cs5200.daos.WidgetDao;
import edu.northeastern.cs5200.daos.WidgetImpl;
import edu.northeastern.cs5200.models.DType;
import edu.northeastern.cs5200.models.Developer;
import edu.northeastern.cs5200.models.Page;
import edu.northeastern.cs5200.models.Priviledge;
import edu.northeastern.cs5200.models.Role;
import edu.northeastern.cs5200.models.User;
import edu.northeastern.cs5200.models.Website;
import edu.northeastern.cs5200.models.Widget;

public class hw_jdbc_voleti_ravi {

  // Main Execution.
  public static void main(String[] args) {

    // Instantiate all the DAOs.

    // DAO to create table if not done so already.
    CreateTableImpl createTablesDao = new CreateTableDao();

    // DAO for developer.
    DeveloperImpl developerDao = new DeveloperDao();

    // DAO for User.
    UserImpl userDao = new UserDao();

    // DAO for Website.
    WebsiteImpl websiteDao = new WebsiteDao();

    // DAO for Page.
    PageImpl pageDao = new PageDao();

    // DAO for Page and Website Roles.
    RoleImpl roleDao = new RoleDao();

    // DAO fir Page and Website Priviledges.
    PriviledgeImpl priviledgeDao = new PriviledgeDao();

    // DAO for Widget.
    WidgetImpl widgetDao = new WidgetDao();

    // CREATE TABLES.
    createTablesDao.createTable();

    // INSERT DATA.

    // Table 1.

    Developer dev1 = new Developer(12, "4321rewq", "Alice", "Wonder",
            "alice", "alice", "alice@wonder.com", null);

    developerDao.createDeveloper(dev1);

    Developer dev2 = new Developer(23, "5432trew", "Bob", "Marley",
            "bob", "bob", "bob@marley.com", null);

    developerDao.createDeveloper(dev2);

    Developer dev3 = new Developer(34, "6543ytre", "Charles", "Garcia",
            "charlie", "charlie", "chuch@garcia.com", null);

    developerDao.createDeveloper(dev3);

    User user4 = new User(45, "Dan", "Martin", "dan", "dan",
            "dan@martin.com");

    userDao.createUser(user4);

    User user5 = new User(56, "Ed", "Karaz", "ed", "ed",
            "ed@kar.com");

    userDao.createUser(user5);


    // Table 2.

    Website web1 = new Website(123, "Facebook",
            "an online social media and social networking service",
            java.sql.Date.valueOf("2019-10-20"), java.sql.Date.valueOf("2019-10-20"),
            1234234);

    websiteDao.createWebsiteForDeveloper(12, web1);

    roleDao.assignWebsiteRole(12, Role.owner, 123);
    priviledgeDao.assignWebsitePrivilege(12, 123, "create");
    priviledgeDao.assignWebsitePrivilege(12, 123, "read");
    priviledgeDao.assignWebsitePrivilege(12, 123, "update");
    priviledgeDao.assignWebsitePrivilege(12, 123, "delete");

    roleDao.assignWebsiteRole(23, Role.editor, 123);
    priviledgeDao.assignWebsitePrivilege(23, 123, "read");
    priviledgeDao.assignWebsitePrivilege(23, 123, "update");

    roleDao.assignWebsiteRole(34, Role.admin, 123);
    priviledgeDao.assignWebsitePrivilege(34, 123, "create");
    priviledgeDao.assignWebsitePrivilege(34, 123, "read");
    priviledgeDao.assignWebsitePrivilege(34, 123, "update");
    priviledgeDao.assignWebsitePrivilege(34, 123, "delete");


    Website web2 = new Website(234, "Twitter",
            "an online news and social networking service",
            java.sql.Date.valueOf("2019-10-20"), java.sql.Date.valueOf("2019-10-20"),
            4321543);

    websiteDao.createWebsiteForDeveloper(23, web2);

    roleDao.assignWebsiteRole(23, Role.owner, 234);
    priviledgeDao.assignWebsitePrivilege(23, 234, "create");
    priviledgeDao.assignWebsitePrivilege(23, 234, "read");
    priviledgeDao.assignWebsitePrivilege(23, 234, "update");
    priviledgeDao.assignWebsitePrivilege(23, 234, "delete");

    roleDao.assignWebsiteRole(34, Role.editor, 234);
    priviledgeDao.assignWebsitePrivilege(34, 234, "read");
    priviledgeDao.assignWebsitePrivilege(34, 234, "update");

    roleDao.assignWebsiteRole(12, Role.admin, 234);
    priviledgeDao.assignWebsitePrivilege(12, 234, "create");
    priviledgeDao.assignWebsitePrivilege(12, 234, "read");
    priviledgeDao.assignWebsitePrivilege(12, 234, "update");
    priviledgeDao.assignWebsitePrivilege(12, 234, "delete");

    Website web3 = new Website(345, "Wikipedia",
            "a free online encyclopedia",
            java.sql.Date.valueOf("2019-10-20"), java.sql.Date.valueOf("2019-10-20"),
            3456654);

    websiteDao.createWebsiteForDeveloper(34, web3);

    roleDao.assignWebsiteRole(34, Role.owner, 345);
    priviledgeDao.assignWebsitePrivilege(34, 345, "create");
    priviledgeDao.assignWebsitePrivilege(34, 345, "read");
    priviledgeDao.assignWebsitePrivilege(34, 345, "update");
    priviledgeDao.assignWebsitePrivilege(34, 345, "delete");

    roleDao.assignWebsiteRole(12, Role.editor, 345);
    priviledgeDao.assignWebsitePrivilege(12, 345, "read");
    priviledgeDao.assignWebsitePrivilege(12, 345, "update");

    roleDao.assignWebsiteRole(23, Role.admin, 345);
    priviledgeDao.assignWebsitePrivilege(23, 345, "create");
    priviledgeDao.assignWebsitePrivilege(23, 345, "read");
    priviledgeDao.assignWebsitePrivilege(23, 345, "update");
    priviledgeDao.assignWebsitePrivilege(23, 345, "delete");

    Website web4 = new Website(456, "CNN",
            "an American basic cable and satellite television news channel",
            java.sql.Date.valueOf("2019-10-20"), java.sql.Date.valueOf("2019-10-20"),
            6543345);

    websiteDao.createWebsiteForDeveloper(12, web4);

    roleDao.assignWebsiteRole(12, Role.owner, 456);
    priviledgeDao.assignWebsitePrivilege(12, 456, "create");
    priviledgeDao.assignWebsitePrivilege(12, 456, "read");
    priviledgeDao.assignWebsitePrivilege(12, 456, "update");
    priviledgeDao.assignWebsitePrivilege(12, 456, "delete");

    roleDao.assignWebsiteRole(23, Role.editor, 456);
    priviledgeDao.assignWebsitePrivilege(23, 456, "read");
    priviledgeDao.assignWebsitePrivilege(23, 456, "update");

    roleDao.assignWebsiteRole(34, Role.admin, 456);
    priviledgeDao.assignWebsitePrivilege(34, 456, "create");
    priviledgeDao.assignWebsitePrivilege(34, 456, "read");
    priviledgeDao.assignWebsitePrivilege(34, 456, "update");
    priviledgeDao.assignWebsitePrivilege(34, 456, "delete");

    Website web5 = new Website(567, "CNET",
            "an American media website that publishes reviews, news, articles, blogs," +
                    " podcasts and videos on technology and consumer electronics",
            java.sql.Date.valueOf("2019-10-20"), java.sql.Date.valueOf("2019-10-20"),
            5433455);

    websiteDao.createWebsiteForDeveloper(23, web5);

    roleDao.assignWebsiteRole(23, Role.owner, 567);
    priviledgeDao.assignWebsitePrivilege(23, 567, "create");
    priviledgeDao.assignWebsitePrivilege(23, 567, "read");
    priviledgeDao.assignWebsitePrivilege(23, 567, "update");
    priviledgeDao.assignWebsitePrivilege(23, 567, "delete");

    roleDao.assignWebsiteRole(34, Role.editor, 567);
    priviledgeDao.assignWebsitePrivilege(34, 567, "read");
    priviledgeDao.assignWebsitePrivilege(34, 567, "update");

    roleDao.assignWebsiteRole(12, Role.admin, 567);
    priviledgeDao.assignWebsitePrivilege(12, 567, "create");
    priviledgeDao.assignWebsitePrivilege(12, 567, "read");
    priviledgeDao.assignWebsitePrivilege(12, 567, "update");
    priviledgeDao.assignWebsitePrivilege(12, 567, "delete");

    Website web6 = new Website(678, "Gizmodo",
            "a design, technology, science and science fiction" +
                    " website that also writes articles on politics",
            java.sql.Date.valueOf("2019-10-20"), java.sql.Date.valueOf("2019-10-20"),
            4322345);

    websiteDao.createWebsiteForDeveloper(34, web6);

    roleDao.assignWebsiteRole(34, Role.owner, 678);
    priviledgeDao.assignWebsitePrivilege(34, 678, "create");
    priviledgeDao.assignWebsitePrivilege(34, 678, "read");
    priviledgeDao.assignWebsitePrivilege(34, 678, "update");
    priviledgeDao.assignWebsitePrivilege(34, 678, "delete");

    roleDao.assignWebsiteRole(12, Role.editor, 678);
    priviledgeDao.assignWebsitePrivilege(12, 678, "read");
    priviledgeDao.assignWebsitePrivilege(12, 678, "update");

    roleDao.assignWebsiteRole(23, Role.admin, 678);
    priviledgeDao.assignWebsitePrivilege(23, 678, "create");
    priviledgeDao.assignWebsitePrivilege(23, 678, "read");
    priviledgeDao.assignWebsitePrivilege(23, 678, "update");
    priviledgeDao.assignWebsitePrivilege(23, 678, "delete");


    // Table 3

    Page page1 = new Page(123, "Home", "Landing Page",
            java.sql.Date.valueOf("2019-09-04"), java.sql.Date.valueOf("2019-09-04"), 123434);

    pageDao.createPageForWebsite(567, page1);

    roleDao.assignPageRole(12, Role.editor, 123);
    priviledgeDao.assignPagePriviledge(12, 123, "read");
    priviledgeDao.assignPagePriviledge(12, 123, "update");

    roleDao.assignPageRole(23, Role.reviewer, 123);
    priviledgeDao.assignPagePriviledge(23, 123, "read");

    roleDao.assignPageRole(34, Role.writer, 123);
    priviledgeDao.assignWebsitePrivilege(34, 123, "create");
    priviledgeDao.assignPagePriviledge(34, 123, "read");
    priviledgeDao.assignPagePriviledge(34, 123, "update");


    Page page2 = new Page(234, "About", "Website description",
            java.sql.Date.valueOf("2019-09-04"), java.sql.Date.valueOf("2019-09-04"), 234545);

    pageDao.createPageForWebsite(678, page2);

    roleDao.assignPageRole(23, Role.editor, 234);
    priviledgeDao.assignPagePriviledge(23, 234, "read");
    priviledgeDao.assignPagePriviledge(23, 234, "update");

    roleDao.assignPageRole(34, Role.reviewer, 234);
    priviledgeDao.assignPagePriviledge(34, 234, "read");

    roleDao.assignPageRole(12, Role.writer, 234);
    priviledgeDao.assignWebsitePrivilege(12, 234, "create");
    priviledgeDao.assignPagePriviledge(12, 234, "read");
    priviledgeDao.assignPagePriviledge(12, 234, "update");


    Page page3 = new Page(345, "Contact", "Addresses, phones, and contact info",
            java.sql.Date.valueOf("2019-09-04"), java.sql.Date.valueOf("2019-09-04"), 345656);

    pageDao.createPageForWebsite(345, page3);

    roleDao.assignPageRole(34, Role.editor, 345);
    priviledgeDao.assignPagePriviledge(34, 345, "read");
    priviledgeDao.assignPagePriviledge(34, 345, "update");

    roleDao.assignPageRole(12, Role.reviewer, 345);
    priviledgeDao.assignPagePriviledge(12, 345, "read");

    roleDao.assignPageRole(23, Role.writer, 345);
    priviledgeDao.assignWebsitePrivilege(23, 345, "create");
    priviledgeDao.assignPagePriviledge(23, 345, "read");
    priviledgeDao.assignPagePriviledge(23, 345, "update");


    Page page4 = new Page(456, "Preferences",
            "Where users can configure their preferences",
            java.sql.Date.valueOf("2019-09-04"), java.sql.Date.valueOf("2019-09-04"), 456776);

    pageDao.createPageForWebsite(456, page4);

    roleDao.assignPageRole(12, Role.editor, 456);
    priviledgeDao.assignPagePriviledge(12, 456, "read");
    priviledgeDao.assignPagePriviledge(12, 456, "update");

    roleDao.assignPageRole(23, Role.reviewer, 456);
    priviledgeDao.assignPagePriviledge(23, 456, "read");

    roleDao.assignPageRole(34, Role.writer, 456);
    priviledgeDao.assignWebsitePrivilege(34, 456, "create");
    priviledgeDao.assignPagePriviledge(34, 456, "read");
    priviledgeDao.assignPagePriviledge(34, 456, "update");

    Page page5 = new Page(567, "Profile",
            "Users can configure their personal information",
            java.sql.Date.valueOf("2019-09-04"), java.sql.Date.valueOf("2019-09-04"), 567878);

    pageDao.createPageForWebsite(567, page5);

    roleDao.assignPageRole(23, Role.editor, 567);
    priviledgeDao.assignPagePriviledge(23, 567, "read");
    priviledgeDao.assignPagePriviledge(23, 567, "update");

    roleDao.assignPageRole(34, Role.reviewer, 567);
    priviledgeDao.assignPagePriviledge(34, 567, "read");

    roleDao.assignPageRole(12, Role.writer, 567);
    priviledgeDao.assignWebsitePrivilege(12, 567, "create");
    priviledgeDao.assignPagePriviledge(12, 567, "read");
    priviledgeDao.assignPagePriviledge(12, 567, "update");

    // Table 4

    Widget widget1 = new Widget(1, "head123", 0, 0, null, null,
            "Welcome", 0, 0, null, null, null, false,
            false, DType.heading);

    widgetDao.createWidgetForPage(123, widget1);

    Widget widget2 = new Widget(2, "post234", 0, 0, null, null,
            "<p>Lorem</p>", 0, 0, null, null, null, false,
            false, DType.html);

    widgetDao.createWidgetForPage(234, widget2);

    Widget widget3 = new Widget(3, "head345", 0, 0, null, null,
            "Hi", 1, 0, null, null, null, false,
            false, DType.heading);

    widgetDao.createWidgetForPage(345, widget3);

    Widget widget4 = new Widget(4, "intro456", 0, 0, null, null,
            "<h1>Hi<h1>", 2, 0, null, null, null, false,
            false, DType.html);

    widgetDao.createWidgetForPage(345, widget4);

    Widget widget5 = new Widget(5, "image345", 50, 100, null,
            null, null, 3, 0, null, "/img/567.png", null,
            false, false, DType.image);

    widgetDao.createWidgetForPage(345, widget5);

    Widget widget6 = new Widget(6, "video456", 400, 300, null,
            null, null, 0, 0, null, null,
            "https://youtu.be/h67VX51QXiQ", false, false, DType.youtube);

    widgetDao.createWidgetForPage(456, widget6);

    // UPDATES

    // 1. update primary phone number.
    Developer devCharlieUpdate = new Developer(34, "6543ytre", "Charles",
            "Garcia", "charlie", "charlie", "chuch@garcia.com",
            null, null, "3334445555");
    developerDao.updateDeveloper(34, devCharlieUpdate);

    // 2. update relative order of widget.

    Widget widgetUpdateOrder1 = new Widget(3, "head345", 0, 0,
            null, null, "Hi", 3, 0, null, null,
            null, false, false, DType.heading);

    widgetDao.updateWidget(3, widgetUpdateOrder1);

    Widget widgetUpdateOrder2 = new Widget(4, "intro456", 0, 0,
            null, null, "<h1>Hi<h1>", 1, 0, null, null,
            null, false, false, DType.html);

    widgetDao.updateWidget(4, widgetUpdateOrder2);

    Widget widgetUpdateOrder3 = new Widget(5, "image345", 50, 100,
            null, null, null, 2, 0, null, "/img/567.png",
            null, false, false, DType.image);

    widgetDao.updateWidget(5, widgetUpdateOrder3);

    // 3.Update CNET

    Page pageUpdateCNET1 = new Page(123, "CNET -Home", "Landing Page",
            java.sql.Date.valueOf("2019-09-04"), java.sql.Date.valueOf("2019-09-04"), 123434);

    pageDao.updatePage(567, pageUpdateCNET1);

    Page pageUpdateCNET2 = new Page(567, "CNET -Profile",
            "Users can configure their personal information",
            java.sql.Date.valueOf("2019-09-04"), java.sql.Date.valueOf("2019-09-04"), 567878);

    pageDao.updatePage(567, pageUpdateCNET2);

    // 4. Update Charlie and Bob's role in CNET's Home page.

    roleDao.deletePageRole(23, 123, -1);
    priviledgeDao.deletePagePriviledge(23, 123, "");

    roleDao.deletePageRole(34, 123, -1);
    priviledgeDao.deletePagePriviledge(34, 123, "");


    roleDao.assignPageRole(34, Role.reviewer, 123);
    priviledgeDao.assignPagePriviledge(34, 123, "read");

    roleDao.assignPageRole(23, Role.writer, 123);
    priviledgeDao.assignWebsitePrivilege(23, 123, "create");
    priviledgeDao.assignPagePriviledge(23, 123, "read");
    priviledgeDao.assignPagePriviledge(23, 123, "update");

    // DELETES

    // 1. updating alice as there is no address or phone number..
    Developer devUpdateAlicePrimary = new Developer(12, "4321rewq",
            "Alice", "Wonder", "alice", "alice",
            "alice@wonder.com", null, null, null);
    developerDao.updateDeveloper(12, devUpdateAlicePrimary);

    // 2. delete the widget with the highest order.
    widgetDao.deleteWidget(3);

    // 3. delete wikipedia page
    pageDao.deletePage(345);

    // 4. delete CNET
    websiteDao.deleteWebsite(567);
    pageDao.deletePage(123);
    pageDao.deletePage(567);

    roleDao.deleteWebsiteRole(12, 567, -1);
    roleDao.deleteWebsiteRole(23, 567, -1);
    roleDao.deleteWebsiteRole(34, 567, -1);

    roleDao.deletePageRole(12, 123, -1);
    roleDao.deletePageRole(23, 123, -1);
    roleDao.deletePageRole(34, 123, -1);

    roleDao.deletePageRole(12, 567, -1);
    roleDao.deletePageRole(23, 567, -1);
    roleDao.deletePageRole(34, 567, -1);

    priviledgeDao.deleteWebsitePriviledge(12, 567, "");
    priviledgeDao.deleteWebsitePriviledge(23, 567, "");
    priviledgeDao.deleteWebsitePriviledge(34, 567, "");

    priviledgeDao.deletePagePriviledge(12, 123, "");
    priviledgeDao.deletePagePriviledge(23, 123, "");
    priviledgeDao.deletePagePriviledge(34, 123, "");

    priviledgeDao.deletePagePriviledge(12, 123, "");
    priviledgeDao.deletePagePriviledge(23, 123, "");
    priviledgeDao.deletePagePriviledge(34, 123, "");


    // Stored Procedures
    /*
    // procedure 1.
    create procedure getUnansweredQuestions
    begin
    select q.text, count(*)
    from question q
    join user u on u.id = q.user
    join answer a on u.id = a.user
    where a.answer = false
    GROUP BY q.module;
    end


    // procedure 2.
    create procedure endorsedUsersForWeek
    begin
    select TOP 5 *
            from question q
    join user u on u.id = q.user
    join person p on u.id = p.id
    where q.endorsedByInstructor = true
    order by u.id;
    end
    */
  }
}
