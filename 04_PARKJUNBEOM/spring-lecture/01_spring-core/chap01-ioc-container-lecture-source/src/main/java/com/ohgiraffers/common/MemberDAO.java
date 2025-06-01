package com.ohgiraffers.common;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

//@Component
@Repository
public class MemberDAO {

    private final Map<Integer, MemberDTO> memberMap;

    public MemberDAO() {
        this.memberMap = new HashMap<Integer, MemberDTO>();
        this.memberMap.put(1, new MemberDTO(1, "user01", "pass01", "홍길동"));
        this.memberMap.put(2, new MemberDTO(2, "user02", "pass02", "유관순"));
    }

    /* 매개변수로 전달받은 회원번호를 map에서 조회 후 회원 정보를 리턴하는 메소드 */
    public MemberDTO selectMember(int sequence) {
        return this.memberMap.get(sequence);
    }

    /* 매개변수를 전달받은 회원정보를 map에 추가하고 성공 실패 여부를 boolean으로 리턴하는 메소드*/
    public boolean insertMember(MemberDTO member) {
        int before = this.memberMap.size();
        this.memberMap.put(member.getSequence(), member);
        int after = this.memberMap.size();
        return after > before;
    }
}
