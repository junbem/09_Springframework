package com.ohgiraffers.section02.javaconfig;

import org.apache.ibatis.annotations.*;

import java.util.List;

public interface MenuMapper {
    @Results(id="menuResultMap", value = {
            @Result(id = true, property = "menuCode", column = "menu_code"),
            @Result(property = "menuName", column = "menu_name"),
            @Result(property = "menuPrice", column = "menu_price"),
            @Result(property = "categoryCode", column = "category_code"),
            @Result(property = "orderableStatus", column = "orderable_status")
    })
    @Select("SELECT\n" +
            "            menu_code\n" +
            "            , menu_name\n" +
            "            , menu_price\n" +
            "            , category_code\n" +
            "            , orderable_status\n" +
            "        FROM tbl_menu\n" +
            "        WHERE orderable_status = 'Y'\n" +
            "        ORDER BY menu_code"
    )
    List<MenuDTO> selectAllMenu();

    @ResultMap("menuResultMap")
    @Select("SELECT\n" +
            "        menu_code\n" +
            "        , menu_name\n" +
            "        , menu_price\n" +
            "        , category_code\n" +
            "        , orderable_status\n" +
            "        FROM tbl_menu\n" +
            "        WHERE menu_code = #{ menuCode }")
    MenuDTO selectMenuByMenuCode(int menuCode);

    @Insert("INSERT\n" +
            "            INTO tbl_menu(menu_name, menu_price, category_code, orderable_status)\n" +
            "        VALUES\n" +
            "            (#{ menuName }, #{ menuPrice }, #{ categoryCode }, 'Y')")
    int insertMenu(MenuDTO menu);

    @Update("UPDATE tbl_menu\n" +
            "            SET menu_name = #{ menuName }\n" +
            "              , menu_price = #{ menuPrice }\n" +
            "              , category_code = #{ categoryCode }\n" +
            "        WHERE menu_code = #{ menuCode }")
    int updateMenu(MenuDTO menu);

    @Delete("DELETE\n" +
            "            FROM tbl_menu\n" +
            "        WHERE menu_code = #{ menuCode }")
    int deleteMenu(int menuCode);

}
