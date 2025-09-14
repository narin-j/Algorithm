from collections import deque
def bfs(tlst):

    for i,j in tlst:
        arr[i][j]=1

    q = deque()
    w = [[0]*M for _ in range(N)]
    cnt = CNT-3     

    for ti,tj in virus:
        q.append((ti,tj))
        w[ti][tj]=1

    # bfs
    while q:
        ci,cj = q.popleft()
        for di,dj in ((-1,0),(1,0),(0,-1),(0,1)):
            ni,nj = ci+di, cj+dj
            if 0<=ni<N and 0<=nj<M and w[ni][nj]==0 and arr[ni][nj]==0:
                q.append((ni,nj))
                w[ni][nj]=1
                cnt-=1

    # 벽 해체
    for i,j in tlst:
        arr[i][j]=0
    return cnt      

# def dfs(n, tlst):
#     global ans
#     if n==3:    # 벽 3개
#         ans = max(ans, bfs(tlst))
#         return
#
#     for j in range(CNT):
#         if v[j]==0:
#             v[j]=1
#             dfs(n+1, tlst+[lst[j]])
#             v[j]=0

N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]

# [1] 빈칸 위치, 바이러스 위치를 저장
lst = []
virus = []
for i in range(N):
    for j in range(M):
        if arr[i][j]==0:
            lst.append((i,j))
        elif arr[i][j]==2:
            virus.append((i,j))

CNT = len(lst)
v = [0]*CNT
ans = 0

# [1] 백트래킹으로 풀이: 1000mS
# dfs(0, [])
# print(ans)

# [2] 루프 CNT개중에서 3개를 선택(가능한 모든 조합): 300mS
for i in range(CNT-2):
    for j in range(i+1, CNT-1):
        for k in range(j+1, CNT):
            ans = max(ans, bfs([lst[i],lst[j],lst[k]]))
print(ans)