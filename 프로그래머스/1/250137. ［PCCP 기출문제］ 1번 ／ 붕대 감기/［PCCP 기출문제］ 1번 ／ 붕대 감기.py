def solution(bandage, health, attacks):
    # bandage: [시전 시간(t), 초당 회복량(x), 추가 회복량(y)]
    t_casting, x_heal, y_bonus = bandage
    max_health = health
    current_health = health
    
    # 공격 정보를 딕셔너리로 변환하여 시간별로 빠르게 조회 가능하게 함
    # {공격시간: 피해량}
    attack_dict = {time: damage for time, damage in attacks}
    
    success_time = 0  # 붕대 감기 연속 성공 시간
    last_attack_time = attacks[-1][0]
    
    # 1초부터 마지막 공격 시간까지 시뮬레이션
    for t in range(1, last_attack_time + 1):
        # 1. 공격 확인
        if t in attack_dict:
            damage = attack_dict[t]
            current_health -= damage
            success_time = 0  # 연속 성공 시간 초기화
            
            # 체력이 0 이하가 되면 사망
            if current_health <= 0:
                return -1
        
        # 2. 공격이 없는 경우(붕대 감기 진행)
        else:
            current_health += x_heal
            success_time += 1
            
            # 시전 시간 t를 채웠다면 추가 회복
            if success_time == t_casting:
                current_health += y_bonus
                success_time = 0  # 초기화
            
            # 최대 체력을 넘을 수 없음
            if current_health > max_health:
                current_health = max_health
                
    return current_health