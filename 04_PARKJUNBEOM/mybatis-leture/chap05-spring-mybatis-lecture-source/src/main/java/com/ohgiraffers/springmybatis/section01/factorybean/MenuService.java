package com.ohgiraffers.springmybatis.section01.factorybean;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    private final SqlSessionTemplate sqlSession;

    public MenuService(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    public List<MenuDTO> findAllMenuByOrdableStatus(String ordableStatus) {

        List<MenuDTO> menus = sqlSession.getMapper(MenuMapper.class).findAllMenuByOrdableStatus(ordableStatus);

        if(menus != null) {
            menus.forEach(menu -> {
                if("Y".equals(menu.getOrderableStatus())){
                    menu.setMenuName(menu.getMenuName() + "(주문 가능)");
                } else {
                    menu.setMenuName(menu.getMenuName() + "(주문 불가능)");
                }
            });
        }

        return menus;
    }
}
