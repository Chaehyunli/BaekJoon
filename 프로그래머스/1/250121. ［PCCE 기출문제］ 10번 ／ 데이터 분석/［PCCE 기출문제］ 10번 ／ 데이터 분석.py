def solution(data, ext, val_ext, sort_by):
    
    n = len(data)
    
    dic = {"code": 0, "date": 1, "maximum": 2, "remain": 3}
    
    ext_idx = dic[ext]
    
    filtered_data = [row for row in data if row[ext_idx] < val_ext]
    
    sort_idx = dic[sort_by]
    filtered_data.sort(key=lambda x : x[sort_idx])
    
    return filtered_data