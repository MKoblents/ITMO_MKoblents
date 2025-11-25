

import numpy as np

def count_v(a, b, c, d):
    
    a, b, c, d = map(np.array, (a, b, c, d))
    return abs(np.dot(np.cross(b - a, c - a), d - a)) / 6.0

def compare_volumes(A, B, C, D, P):
    V_ABCD = count_v(A, B, C, D)
    
    V_PBCD = count_v(P, B, C, D)
    V_APCD = count_v(A, P, C, D)
    V_ABPD = count_v(A, B, P, D)
    V_ABCP = count_v(A, B, C, P)
    
    V_sum_sub = V_PBCD + V_APCD + V_ABPD + V_ABCP
    
    diff = abs(V_ABCD - V_sum_sub)
    
    return {
        'V_ABCD': V_ABCD,
        'V_sum_sub': V_sum_sub,
        'difference': diff,
        'is_inside': diff < 1e-9
    }

if __name__ == "__main__":
    A = [0, 0, 0]
    B = [1, 0, 0]
    C = [0, 1, 0]
    D = [0, 0, 1]
    P = [0.2, 0.2, 0.2]  

    result = compare_volumes(A, B, C, D, P)
    print("Объём ABCD:", result['V_ABCD'])
    print("Сумма объёмов подпирамид:", result['V_sum_sub'])
    print("Разность:", result['difference'])
    print("Точка P внутри пирамиды?", result['is_inside'])