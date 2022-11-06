기능 목록
- 입력부
  - Class - user_answer : 
    - method - read : camp.nextstep.edu.missionutils.Console의 readLine()을 활용하여 사용자의 답을 읽어들임
    - method - save : 읽어온 user answer를 List에 저장하는 메서드
  - Class - user_answer_check_exceptions : 예외사항 검사부
    - method - is_diff_number : 서로 다른 3자리의 수 확인하고, 아닌 경우 IllegalArgumentException을 발생시키고 종료
    - method - check_game : 게임이 끝난 상태인지 확인 
      - method - restart_game : 게임을 재시작
      - method - exit_game : 게임을 종료
  - Class - computer_answer
      - method - create : camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용하여 Random 값 생성
      - method - save : 생성된 Random number를 answer list에 저장 
- 로직부
  - Class - compare_answer : user의 answer index별로 contains하고있는지 확인
    1) contain한 경우 computer_answer[i] == user_answer[i]인 경우 strike
    2) contain한 경우 computer_answer[i] != user_answer[i]인 경우 ball
  
    - method - strike : 1)의 경우, strike_count++
    - method - ball : 2)의 경우, ball_count++
  
- 출력부
  - Class - print_result : result를 ball, strike 순서로 출력 후 eol 출력
    - method - nothing : 스트라이크, 볼이 0인 경우 낫싱 출력
    - method - ball : baLL이 0이 아닌 경우 ball의 개수 출력
    - method - strike : strike가 0이 아닌 경우 strike의 개수 출력
    - method - end_of_line : 출력을 마친 후 개행문자 출력

