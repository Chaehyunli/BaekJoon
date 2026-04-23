def solution(players, callings):
    
    player_index = {player : i for i, player in enumerate(players)}
    
    for i in range(len(callings)):
        idnex = player_index[callings[i]]  # 현재 불린 선수의 인덱스
        prev_player = players[idnex - 1]  # 앞서고 있던 선수의 이름
        
        # 1. 리스트에서의 위치 교환
        players[idnex - 1], players[idnex] = players[idnex], players[idnex - 1]
        
        player_index[callings[i]] = idnex - 1
        player_index[prev_player] = idnex
    
    return players