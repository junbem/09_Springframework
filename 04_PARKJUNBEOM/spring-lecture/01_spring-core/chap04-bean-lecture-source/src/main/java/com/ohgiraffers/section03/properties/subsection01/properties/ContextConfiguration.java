package com.ohgiraffers.section03.properties.subsection01.properties;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import com.ohgiraffers.section02.subsection02.annotation.Owner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@PropertySource("section03/properties/subsection01/properties/product-info.properties")
public class ContextConfiguration {

    /* 치환자 문법(placeholder) 를 이용하여 properties에 저장 된 키 값을 입력하면
     * value에 해당하는 값이 가져와져서 주입된다.
     * 양 옆에 공백이 있을 경우 값을 읽어오지 못하므로 주의!!
     * 뒤에 : 을 사용하여 key 값이 없을 경우에 대체값을 작성할 수 있다. */
    @Value("붕어빵")
    private String name; // 변수 선언

    @Value("${bread.carpbread.price:0}")
    private int price;

    @Bean
    public Product carpBread() {
        return new Bread(name, price, new java.util.Date()); // 나중에 값을 추가
    }

    @Bean
    public Product milk(@Value("바나나맛우유") String name, @Value("1500") int price, @Value("500") int capacity ) {
        return new Beverage(name, price, capacity);
    }

    @Bean
    public Product water(@Value("${beverage.water.name}")String name,
                         @Value("${beverage.water.price}")int price,
                         @Value("${beverage.water.capacity}")int capacity) {
        return new Beverage(name, price, capacity);
    }

    @Bean
    @Scope("prototype") // 필요시 마다 새로운 인스턴스를 생성해서 반환
    public ShoppingCart cart() {
        return new ShoppingCart();
    }

    @Bean
    public Owner owner() {
        return new Owner();
    }
}
