

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] deltas = {{-1, -1}, {-1, 1}, {1, 1}, {1, -1}};
    static int[][][] parent;
    static int[][] visited;
    static char[] row = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while(T-->0) {
            parent = new int[8][8][2];
            visited = new int[8][8];
            st = new StringTokenizer(br.readLine());
            int[] start = {st.nextToken().charAt(0)-65, Integer.parseInt(st.nextToken())-1};
            int[] target = {st.nextToken().charAt(0)-65, Integer.parseInt(st.nextToken())-1};

            List<int[]> answer = bfs(start, target);

            if(answer==null) sb.append("Impossible").append("\n");
            else {
                sb.append(answer.size()-1).append(" ");
                for(int[] a:answer) {
                    sb.append(row[a[0]]).append(" ").append(a[1]+1).append(" ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    static List<int[]> bfs(int[] start, int[] target) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start[0], start[1]});
        visited[start[0]][start[1]] = 1;

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int cx=curr[0];
            int cy=curr[1];

            if(cx==target[0] && cy==target[1]) return findPath(start, target, visited[cx][cy]);
            if(visited[cx][cy]>4) continue;

            for(int d=0; d<4; d++) {
                for(int i=1; i<8; i++) {
                    int nx = cx+deltas[d][0]*i;
                    int ny = cy+deltas[d][1]*i;

                    if(nx<0 || nx>=8 || ny<0 || ny>=8) break;
                    if(visited[nx][ny]!=0) continue;
                    visited[nx][ny] = visited[cx][cy]+1;
                    parent[nx][ny][0] = cx;
                    parent[nx][ny][1] = cy;
                    q.add(new int[]{nx, ny});
                }
            }
        }

        return null;
    }

    static List<int[]> findPath(int[] start, int[] target, int pathLen) {
        List<int[]> path = new ArrayList<>(pathLen);

        for(int i=0; i<pathLen; i++) {
            path.add(null);
        }
        int cx = target[0];
        int cy = target[1];
        int idx = pathLen-1;

        while(idx>=1) {
            path.set(idx, new int[]{cx, cy});

            int nx = parent[cx][cy][0];
            int ny = parent[cx][cy][1];

            cx=nx;
            cy=ny;
            idx--;
        }

        path.set(0, new int[]{start[0], start[1]});
        return path;
    }
}
