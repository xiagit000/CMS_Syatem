package com.boventech.cms.service.node.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boventech.cms.dao.node.NodeDao;
import com.boventech.cms.module.node.Menu;
import com.boventech.cms.module.node.Node;
import com.boventech.cms.module.node.Order;
import com.boventech.cms.module.right.Operation;
import com.boventech.cms.module.user.User;
import com.boventech.cms.service.node.NodeService;

@Service
@Transactional
public class NodeServiceImpl implements NodeService {

    private NodeDao nodeDao;

    public void addBrother(Node current, Node brother) {
        // TODO
    }

    public void addChild(Node current, Node child) {
        current.addChild(child);
        this.nodeDao.update(current);
    }

    public void delete(Node t) {
        Integer parentId = t.getParent() != null ? t.getParent().getId() : null;
        int maxPosition = this.nodeDao.count(parentId);
        int position = t.getPosition();
        if (position < maxPosition) {
            this.nodeDao.changePosition(parentId, position);
        }
        this.nodeDao.delete(t);
    }

    public Node findById(Integer id) {
        return this.nodeDao.findById(id);
    }

    public void save(Node t) {
        this.nodeDao.save(t);
    }

    public void update(Node t) {
        this.nodeDao.update(t);
    }

    public void setNodeDao(NodeDao nodeDao) {
        this.nodeDao = nodeDao;
    }

    public List<Node> listNodes(Integer parentId) {
        return this.nodeDao.findByParentId(parentId);
    }

    public void shiftDown(Integer id, Integer parentId, int position) {
        int maxPosition = this.nodeDao.count(parentId);
        if (position < maxPosition) {
            this.nodeDao.changePosition(id, parentId, position, position + 1);
        }
    }

    public void shiftUp(Integer id, Integer parentId, int position) {
        if (position > 1) {
            this.nodeDao.changePosition(id, parentId, position, position - 1);
        }
    }

    public int getPosition(Integer parentId) {
        return this.nodeDao.count(parentId);
    }

    public List<Node> listNodes(Integer parentId, boolean display) {
        return this.nodeDao.findByParentId(parentId, display);
    }

    public void delete(Integer id) {
        Node node = this.nodeDao.findById(id);
        delete(node);
    }

    public List<Menu> listMenu(boolean display) {
        List<Object[]> results = this.nodeDao.listTree(display);
        System.out.println("list tree with size: " + results.size());
        return cleanResults(results);
    }

    private List<Menu> cleanResults(List<Object[]> results) {
        List<Menu> menus = new ArrayList<Menu>();
        for (Object[] result : results) {
            Menu menu = new Menu();
            menu.setNodeId(result[0] != null ? ((Number) result[0]).intValue() : null);
            menu.setName(String.valueOf(result[1]));
            menu.setParentId(result[2] != null ? ((Number) result[2]).intValue() : null);

            menu.setOrders(Order.valueOf(String.valueOf(result[3])));
            menus.add(menu);
        }
        return menus;
    }

    public List<Menu> listMenu(boolean display, Integer parentId) {
        List<Object[]> results = this.nodeDao.listTree(display, parentId);
        return cleanResults(results);
    }

    public List<Node> listUserVisiableNodes(User user) {
        List<Node> results = new ArrayList<Node>();
        List<Node> nodes = this.nodeDao.list();
        for (Node node : nodes) {
            if (node.isAuthrized(user, Operation.EDIT_NODE)) {
                results.add(node);
            }
        }
        return results;
    }

    public List<Node> listUserVisiableNodes(User user, Integer parentId) {
        List<Node> results = new ArrayList<Node>();
        List<Node> nodes = this.nodeDao.findByParentId(parentId);
        for (Node node : nodes) {
            if (node.isAuthrized(user, Operation.EDIT_NODE)) {
                results.add(node);
            }
        }
        return results;
    }

    public List<Menu> listUserVisiableMenus(User user) {
        List<Menu> menus = new ArrayList<Menu>();
        List<Node> nodes = this.nodeDao.findByParentId(null);
        for (Node node : nodes) {
            addRootNodeToMenu(user, node, menus, 1);
        }
        return menus;
    }

    private void addRootNodeToMenu(User user, Node node, List<Menu> menus, int level) {
        if (node.isAuthrized(user, Operation.EDIT_NODE)) {
            menus.add(convert(node, level, true));
        } else {
            List<Node> children = node.getChildren();
            for (Node child : children) {
                addRootNodeToMenu(user, child, menus, level + 1);
            }
        }
    }

    private Menu convert(Node node, int level, boolean right) {
        Menu menu = Menu.getInstance(node);
        menu.setLevel(level);
        menu.setRight(right);
        return menu;
    }

    public List<Menu> listUserManagedMenus(User user) {
        List<Menu> menus = new ArrayList<Menu>();
        List<Node> nodes = this.nodeDao.findByParentId(null);
        for (Node node : nodes) {
            addAllNodeMenu(user, node, menus, 1);
        }
        return menus;
    }

    private void addAllNodeMenu(User user, Node node, List<Menu> menus, int level) {
        boolean right = node.isAuthrized(user, Operation.EDIT_NODE);
        menus.add(convert(node, level, right));
        List<Node> children = node.getChildren();
        for (Node child : children) {
            addAllNodeMenu(user, child, menus, level + 1);
        }
    }

    public List<Menu> listUserManagedMenuByParent(User user, Integer nodeId) {
        List<Menu> menus = new ArrayList<Menu>();
        List<Node> nodes = this.nodeDao.findByParentId(nodeId);
        for (Node node : nodes) {
            menus.add(convert(node, 1, node.isAuthrized(user, Operation.EDIT_NODE)));
        }
        return menus;
    }

    public Menu getMenu(User user, Node node) {
        if (node != null) {
            return convert(node, 0, node.isAuthrized(user, Operation.EDIT_NODE));
        }
        return null;
    }

    public List<Menu> listParentMenus(Node node) {
        List<Menu> menus = new ArrayList<Menu>();
        List<Node> parents = new ArrayList<Node>();
        Node current = node;
        while (current != null && current.getParent() != null) {
            current = current.getParent();
            parents.add(current);
        }
        Collections.reverse(parents);
        int level = 1;
        for (Node parent : parents) {
            menus.add(convert(parent, level++, false));
        }
        return menus;
    }

    public Node findByName(String name) {
        return this.nodeDao.findByName(name);
    }

}
