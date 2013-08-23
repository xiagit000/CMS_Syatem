package com.boventech.cms.service.node;

import java.util.List;

import com.boventech.cms.module.node.Menu;
import com.boventech.cms.module.node.Node;
import com.boventech.cms.module.user.User;
import com.boventech.cms.service.BasicService;

public interface NodeService extends BasicService<Node> {

    void addChild(Node current, Node child);

    void addBrother(Node current, Node brother);

    List<Node> listNodes(Integer parentId);

    void shiftUp(Integer id, Integer parentId, int position);

    void shiftDown(Integer id, Integer parentId, int position);

    int getPosition(Integer parentId);

    List<Node> listNodes(Integer parentId, boolean display);

    List<Node> listUserVisiableNodes(User user, Integer parentId);

    void delete(Integer id);

    List<Menu> listMenu(boolean display);

    List<Menu> listMenu(boolean b, Integer parentId);

    List<Node> listUserVisiableNodes(User user);

    List<Menu> listUserVisiableMenus(User user);

    List<Menu> listUserManagedMenus(User user);

    List<Menu> listUserManagedMenuByParent(User currentUser, Integer nodeId);

    Menu getMenu(User user, Node node);

    List<Menu> listParentMenus(Node node);

    Node findByName(String name);
}
