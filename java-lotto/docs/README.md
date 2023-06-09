# 기능 구현 목록

## Controller
### LottoGame
- [0] 로또 게임을 실행하며 에러 발생 시 에러 메시지를 출력 후 종료한다.

## domain

### - LottoNumberGenerator
- [O] 구매 로또 번호를 임의로 생성한다.
- [O] 구매 로또 번호를 오름차순으로 정렬한다.

### - Lotto
- [0] 6자리 로또 번호를 갖는다.

### - LottoRank
- [O] 3등이 아닌 경우 당첨 배열에 맞는 WinningCount를 증가시킨다.
- [O] 3등인 경우를 판별하여 당첨 배열에 WinningCount를 증가시킨다.

### - WinningCounter
- [O] 구매 로또 번호의 일반 번호가 당첨 번호와 일치하는 개수를 카운트한다.
- [O] 구매 로또 번호의 보너스 번호가 당첨 번호와 일치하는지 카운트한다.

### - ProfitManager
- [0] 당첨 횟수와 상금을 곱하여 총 수익을 계산한다.
- [O] 로또 구매 비용으로 나누어 수익률을 계산한다.

## UI
### - LottoManager
- [O] 로또 구입 금액을 입력 받는다.
  - [O] 로또 구입 금액의 입력 pattern을 검증한다.
  - [0] 로또 구입 금액이 1000원 단위인지 확인한다.
- [O] 당첨 번호를 입력 받는다.
- [O] 보너스 번호를 입력 받는다.
  - [O] 번호 입력이 숫자 혹은 숫자와 comma로 구분된 Pattern인지 검증한다.
  - [O] 번호의 각 숫자가 1-45 범위 내인지 검증한다.
  - [0] 당첨 번호 배열과 중복되는 번호인지 검증한다.

### LottoPrinter
- [0] 구매 금액 입력 메시지를 출력한다.
- [O] 로또 번호를 출력한다.
- [0] 구매 완료 메시지를 출력한다.
- [0] 당첨 번호 입력 메시지를 출력한다.
- [0] 보너스 번호 입력 메시지를 출력한다.
- [0] 당첨 통계 메시지를 출력한다.
- [0] 당첨 결과 메시지를 출력한다.
- [O] 수익률을 % 단위로 변환하여 소수점 둘째에서 반올림하여 수익률 메시지를 출력한다.
- [0] 에러 메시지를 출력한다.