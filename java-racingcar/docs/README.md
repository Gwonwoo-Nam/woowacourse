### 기능 요구사항

자동차 게임 최종 기능 구현 완료

- InputView
  - [O] 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
  - [O] 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.


- Car
  - [O] 자동차는 시도 횟수를 입력받아 운전한다. 운전은 횟수만큼 이동을 시도하는 것을 의미한다.
    - [O] 이동은 값이 4 이상일 경우 한 칸 앞으로 전진하는 행위이다.
    - [O] 0에서 9 사이에서 무작위 값을 뽑는다.
  - [O] 자동차의 현재 위치를 반환한다.
  - [O] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
    - [O] 자동차 이름은 5자 이하여야 한다.
    - [O] 자동차 이름 간 중복이 없어야 한다.
    - [O] 시도 횟수는 양수 숫자 범위여야 한다.
    - [O] 최소 두 대 이상의 차량이 있어야 한다.

- OutputView
  - [O] 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
  - [O] 우승자를 출력한다.

- Controller
  - [O] 자동차 경주 게임을 완료한 후 자동차의 위치를 비교해 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
    - [O]우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.

