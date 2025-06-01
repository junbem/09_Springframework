package com.ohgiraffers.seciton01.scope.subsection02.prototype;

import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);

        Product carpBread = (Product) context.getBean("carpBread", Product.class);
        Product milk = (Product) context.getBean("milk", Product.class);
        Product water = (Product) context.getBean("water", Product.class);

        System.out.println("쇼핑카트 개체 꺼내기 전");
        ShoppingCart cart1 = context.getBean("cart", ShoppingCart.class);
        System.out.println("쇼핑 카트 객체 꺼낸 다음");
        cart1.addItem(carpBread);
        cart1.addItem(milk);
        System.out.println("cart1에 담긴 내용 : " + cart1.getItem());

        /* 두 번째 손님이 쇼핑 카트를 꺼낸다. */
        ShoppingCart cart2 = context.getBean("cart", ShoppingCart.class);
        cart2.addItem(water);
        /* 지리산암반수가 담겨있다. */
        System.out.println("cart2에 담긴 내용 : " + cart2.getItem());
    }
}
