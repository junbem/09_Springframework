package com.ohgiraffers.section01.autowired.subsection01.field;

import com.ohgiraffers.section01.autowired.common.BookDAO;
import com.ohgiraffers.section01.autowired.common.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    /* BookDAO 타입의 빈 객체를 생성자에 자동으로 주입해준다. */
    @Autowired // 필드 주입
    private BookDAO bookDAO;

    // private BookDAO bookDAO = new BookDAOImpl();
    /* 도서 목록 전체 조회 */
    public List<BookDTO> selectAllBooks(){
        return bookDAO.selectBookList();
    }
    /* 도서 번호로 도서 조회 */
    public BookDTO searchBookBySequence(int sequence) {
        return bookDAO.selectOneBook(sequence);
    }

}
