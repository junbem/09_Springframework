package com.ohgiraffers.section01.xmlconfig;

import java.util.List;
import java.util.Map;

public class MenuController {
    private final PrintResult printResult;
    private final MenuService menuService;

    public MenuController() {
        this.printResult = new PrintResult();
        this.menuService = new MenuService();
    }
    public void selectAllMenu(){
        List<MenuDTO> menuList = menuService.selectAllMenu();
        if(menuList != null && !menuList.isEmpty()){
            printResult.printMenuList(menuList);
        }else{
            printResult.printErrorMessage("selectList");
        }
    }

    public void selectMenuByMenuCode(Map<String, String> parameter) {

        int menuCode = Integer.parseInt(parameter.get("menuCode"));

        MenuDTO menu = menuService.selectMenuByMenuCode(menuCode);

        if(menu != null ){
            printResult.printMenu(menu);
        }else{
            printResult.printErrorMessage("selectOne");
        }
    }

    public void registMenu(Map<String, String>parameter) {

        MenuDTO menu = new MenuDTO();
        menu.setMenuName(parameter.get("menuName"));
        menu.setMenuPrice(Integer.parseInt(parameter.get("menuPrice")));
        menu.setCategoryCode(Integer.parseInt(parameter.get("categoryCode")));

        if(menuService.registMenu(menu)) {
            printResult.printSuccessMessage("insert");
        } else {
            printResult.printErrorMessage("insert");
        }
    }

    public void modifyMenu(Map<String, String> stringStringMap) {
        MenuDTO menu = new MenuDTO();
        menu.setMenuCode(Integer.parseInt(stringStringMap.get("menuCode")));
        menu.setMenuName(stringStringMap.get("menuName"));
        menu.setMenuPrice(Integer.parseInt(stringStringMap.get("menuPrice")));
        menu.setCategoryCode(Integer.parseInt(stringStringMap.get("categoryCode")));

        if(menuService.modifyMenu(menu)) {
            printResult.printSuccessMessage("update");
        } else {
            printResult.printErrorMessage("update");
        }
    }

    public void deleteMenu(Map<String, String> stringStringMap) {
        int menuCode = Integer.parseInt(stringStringMap.get("menuCode"));

        if(menuService.deleteMenu(menuCode)) {
            printResult.printSuccessMessage("delete");
        } else {
            printResult.printErrorMessage("delete");
        }
    }
}