import java.util.ArrayDeque;
import java.util.Deque;

class Simplify {

    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        for (String s : path.split("/")) {
            if (s.equals("..") && !stack.isEmpty()) {
                stack.pop();
            }
            if (!s.equals("") && !s.equals(".") && !s.equals("..")) {
                stack.push(s);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append("/").append(stack.pollLast());
        }
        return sb.toString();
    }
}

