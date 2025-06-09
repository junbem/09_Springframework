package com.ohgiraffers.restapi.section05.swagger;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Tag(name= "Spring Boot Swagger 연동(user)")
@RestController
@RequestMapping("/swagger")
public class SwaggerTestController {

    private List<UserDTO> users;

    public SwaggerTestController() {
        users = new ArrayList<>();
        users.add(new UserDTO(1, "user01", "pass01", "유관순"));
        users.add(new UserDTO(1, "user02", "pass02", "홍길동"));
        users.add(new UserDTO(1, "user03", "pass03", "이순신"));
    }

    @Operation(
            summary = "전체 회원 조회", description = "전체 회원 목록을 조회한다."
    )

    @GetMapping("/users")
    public ResponseEntity<com.ohgiraffers.restapi.section05.swagger.ResponseMessage> findAllUsers() {
        /* 응답 헤더 설정 : JSON 응답이 default 이기는 하나 변경이 필요한 경우 HttpHeaders 설정 변경 */
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(
                new MediaType("application","json", StandardCharsets.UTF_8)
        );
        /* 응답 바디 설정 */
        Map<String,Object> responseMap = new HashMap<>();
        responseMap.put("users",users);

        /* 응답 메세지 설정 */
        com.ohgiraffers.restapi.section05.swagger.ResponseMessage responseMessage = new com.ohgiraffers.restapi.section05.swagger.ResponseMessage(
                200,"조회 성공",responseMap
        );
        return new ResponseEntity<>(responseMessage, httpHeaders, HttpStatus.OK);
    }

    @Operation(
            summary = "회원 번호로 회원 조회", description = "회원 번호로 회원을 조회한다."
    )
    @GetMapping("/users/{userNo}")
    public ResponseEntity<com.ohgiraffers.restapi.section05.swagger.ResponseMessage> findUserByNo(@PathVariable int userNo) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(
                new MediaType("application","json", StandardCharsets.UTF_8)
        );
        /* 응답 바디 설정 */
        Map<String,Object> responseMap = new HashMap<>();
        com.ohgiraffers.restapi.section05.swagger.UserDTO founduser = users.stream().filter(user -> user.getNo() == userNo).findFirst().get();
        responseMap.put("user",founduser);

        /* 응답 메세지 설정 */
        com.ohgiraffers.restapi.section05.swagger.ResponseMessage responseMessage = new com.ohgiraffers.restapi.section05.swagger.ResponseMessage(
                200,"조회 성공",responseMap
        );
        return new ResponseEntity<>(responseMessage, httpHeaders, HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<ResponseMessage> registUser(@RequestBody com.ohgiraffers.restapi.section05.swagger.UserDTO userDTO) {
        int lastUserNo = users.get(users.size()-1).getNo();
        userDTO.setNo(lastUserNo+1);
        users.add(userDTO);

        return  ResponseEntity
                .created(URI.create("/entity/users/"+users.get(users.size()-1).getNo()))
                .build();
    }

    @Operation(
            summary = "회원 번호로 회원 수정", description = "회원 번호로 회원을 수정한다."
    )
    @PutMapping("/users/{userNo}")
    public ResponseEntity<Void> modifyUser(
            @PathVariable int userNo, @RequestBody com.ohgiraffers.restapi.section05.swagger.UserDTO userDTO
    ) {
        com.ohgiraffers.restapi.section05.swagger.UserDTO foundUser = users.stream().filter(user -> user.getNo() == userNo).findFirst().get();
        foundUser.setPwd(userDTO.getPwd());
        foundUser.setName(userDTO.getName());

        return  ResponseEntity.created(URI.create("/entity/users/"+userNo)).build();
    }
    
    @Operation(
            summary = "회원 번호로 회원 삭제", description = "전체 회원 목록을 조회한다."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "회원정보 삭제 완료"),
            @ApiResponse(responseCode = "400", description = "잘못 입력된 파라미터")
    })
    @DeleteMapping("/users/{userNo}")
    public ResponseEntity<Void> deleteUser(@PathVariable int userNo) {
        com.ohgiraffers.restapi.section05.swagger.UserDTO foundUser = users.stream().filter(user -> user.getNo() == userNo).findFirst().get();
        users.remove(foundUser);
        return  ResponseEntity.noContent().build();
    }
}
