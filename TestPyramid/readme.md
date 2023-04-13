# Test pyramid
![img.png](img.png)

* 피라미드 형태로 Test의 계층을 분리한 사진.
* 피라미드의 아래로 갈수록 커버할 수 있는 영역이 넓어지고 빨라진다.
* 고수준으로 갈수록 원하는 기능에 대한 테스트가 정확하게 이루어질 수 있다.
## 각 테스트별 의미
Unit Test(단위 테스트) : 가장 작고 빠르다. 동작이나 하나의 함수를 테스트한다. 외부와 격리된다.

Integration Test(통합 테스트) : 시스템의 서로 다른 모듈이나 구성 요소간의 상호작용을 테스트한다. (DB와 같은)

E2E(End to end : 종단 테스트) : 실제 사용자 시나리오를 시뮬레이션하여 전체 시스템을 검증한다.

### Unit test
시스템의 다른 부분에 대한 종속성이 없고 격리된 특정 부분을 테스트하도록 설계한다.

다양한(또는 이상한) 입력 및 예상 출력으로 각 기능을 테스트하는데 집중한다.
```java
@Test
@DisplayName("UseAggregate updateUserId에 null을 넣으면 NPE를 반환한다.")
void userId_isNull() throws ServiceException {
        UserAggregate newUser = UserAggregate.builder().build();
        assertThrows(NullPointerException.class, () -> newUser.updateUserId(null));
}
```

### Integration test
시스템의 다양한 부분이 함께 올바르게 동작하는지 확인한다.
```java
@Test
@DisplayName("CreateRequest를 던지면 신규 유저를 생성해주고, user Id로 꺼낼 수 있다.")
void createNewUser_And_GetTest() throws ServiceException {
        UserAggregate newUser = userService.createNewUser(TestUtil.randomCreateUserRequest());

        UserAggregate foundUser = userService.getUserWithId(newUser.getUserId());

        assertThat(newUser, samePropertyValuesAs(foundUser));
}
```

### E2E test
가장 높은 수준의 테스트로 시스템의 처음-끝을 검증한다.

종단 테스트는 시스템의 주요 사례 및 워크 플로우를 다뤄야 하며 시스템이 각 시나리오에서

예상대로 동작하는지 확인할 수 있다.

```java
@Test
@DisplayName("UserId로 유저의 정보를 얻어올 수 있다.")
void getUserAPI() throws Exception {
    //given
    String expectedId = "inputId";
    
    //when
    UserAggregate user = given(get("/user/${expectedId}?format=full")).then().as(UserAggregate.class);
    String actual = user.getId();
    
    //then
    assertThat(actual).isEqualTo(expectedId);
}
```

---
https://www.youtube.com/watch?v=4q9d8Aye0nY
https://www.browserstack.com/guide/testing-pyramid-for-test-automation