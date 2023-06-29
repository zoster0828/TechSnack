# 9. 코드를 재사용하고 일반화할 수 있도록 하라
* 하위 문제에 대한 해결책이 있다고 해서 그걸 꼭 재사용 할 수 있는것은 아님
* 간결한 추상화 계층을 만들고 코드를 모듈화 하여 하위 문제의 해결책을 느슨하게 만들자
## 9.1 가정을 주의하라
* 어느 부분에서 어떤 가정이 이루어졌는지 시간이 지나 추적하는 것은 불가능하다
### 9.1.1 가정은 코드 재사용 시 버그를 초래할 수 있다
* return이 하나만 있을거라고 가정했지만 사실은 여러개인 경우
> 심지어 나중에 변경된 경우
### 9.1.2 해결책: 불필요한 가정을 피하라
* 가정이 발생할 것을 우려해 가정을 가지고 코드를 작성하면 가독성이 떨어질 뿐 아니라 기회비용이 커진다
### 9.1.3 해결책: 가정이 필요하면 강제적으로 하라
* 가정 발생 시 컴파일 에러 또는 강한 알람 발생
```json
{
  "categoryList" : [
    {"category":"category1"},
    {"categoryName": "name1", "categoryValue" : "delete"},
    {"categoryName": "name2", "categoryValue" : "add"},
    {"categoryName": "name2", "categoryValue" : "update"}
  ]
}
```

```java
List<Map<String, String>> result = getCategories();
String categoryString = result.get(0).get("category");

if(categoryString == null) {
    AlertHandler.alert(AlertLevel.CIRITICAL, "first category string is null");
}

List<Category> categories = new ArrayList();
for(int i = 1; i < result.size() ; i++) {
        Category category = CategoryFactory.create(categoryString, result.get(i));
        categories.add(category);
}
 
```
## 9.2 전역 상태를 주의하라
### 9.2.1 전역 상태를 갖는 코드는 재사용하기에 안전하지 않을 수 있다
> spring 코드는 상대적으로 전역에 대한 위험도가 낮은듯 어떻게 생각 하시는지?
### 9.2.2 해결책: 공유 상태에 의존성 주입하라
* 의존성 주입을 통해 상태를 공유하자
> 마찬가지로 spring에서는 자동으로 되는 경향
## 9.3 기본 반환값을 적절하게 사용하라
* 모든 값을 받기보다 없는 경우에 우선순위가 높은 기본 값을 주자
### 9.3.1 낮은 층위의 코드의 기본 반환값은 재사용성을 해칠 수 있다
* low level에 세팅된 기본 값은 재사용을 어렵게 만든다.
### 9.3.2 해결책: 상위수준의 코드에서 기본값을 제공하라
* 흔히 default object pattern을 사용하는 library들을 의미하는 것으로 보임
> 찾기 어려움

## 9.4 함수의 매개변수를 주목하라
### 9.4.1 필요 이상으로 매개변수를 받는 함수는 재사용하기 어려울 수 있다
* 사용하지 않는 변수를 받는 경우, 테스트시 의미없는 변수를 생성하여 전달해야 하는 불편함
### 9.4.2 해결책: 함수는 필요한 것만 매개변수로 받도록 하라
* 필요한것이 너무 많다면, 함수가 너무 많은 일을 하는것은 아닐까

## 9.5 제네릭의 사용을 고려하라
### 9.5.1 특정 유형에 의존하면 일반화를 제한한다
### 9.5.2 해결책: 제네릭을 사용하라
* ObjectMapper.readValue()