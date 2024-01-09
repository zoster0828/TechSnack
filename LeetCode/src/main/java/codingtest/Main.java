package codingtest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        String s = "AI\t389\n" +
                "generative\t274\n" +
                "Community\t196\n" +
                "workloads\t111\n" +
                "cloud\t109\n" +
                "serverless\t100\n" +
                "security\t97\n" +
                "Alliance\t91\n" +
                "scale\t87\n" +
                "performance\t67\n" +
                "analytics\t66\n" +
                "cost\t64\n" +
                "business\t61\n" +
                "Services\t58\n" +
                "architecture\t56\n" +
                "S3\t55\n" +
                "observability\t54\n" +
                "innovation\t54\n" +
                "patterns\t53\n" +
                "SaaS\t53\n" +
                "storage\t48\n" +
                "apps\t46\n" +
                "architectures\t46\n" +
                "Generative\t46\n" +
                "ML\t44\n" +
                "development\t44\n" +
                "resilience\t43\n" +
                "SageMaker\t43\n" +
                "infrastructure\t39\n" +
                "edge\t39\n" +
                "Cloud\t39\n" +
                "EKS\t38\n" +
                "event-driven\t38\n" +
                "Data\t37\n" +
                "management\t37\n" +
                "strategy\t36\n" +
                "ECS\t35\n" +
                "secure\t35\n" +
                "experience\t35\n" +
                "modernization\t35\n" +
                "migration\t35\n" +
                "customer\t34\n" +
                "AI/ML\t33\n" +
                "solutions\t33\n" +
                "network\t33\n" +
                "Advanced\t32\n" +
                "Optimize\t31\n" +
                "Aurora\t31\n" +
                "insights\t31\n" +
                "operations\t31\n" +
                "Lambda\t31\n" +
                "future\t31\n" +
                "Improve\t30\n" +
                "DynamoDB\t29\n" +
                "costs\t29\n" +
                "Kubernetes\t29\n" +
                "platform\t28\n" +
                "optimization\t28\n" +
                "compliance\t28\n" +
                "design\t28\n" +
                "Marketplace\t27\n" +
                "Service\t27\n" +
                "EC2\t27\n" +
                "value\t27\n" +
                "strategies\t27\n" +
                "Fargate\t27\n" +
                "learning\t27\n" +
                "RDS\t27\n" +
                "Automate\t26\n" +
                "digital\t26\n" +
                "real-time\t26\n" +
                "optimize\t26\n" +
                "models\t26\n" +
                "productivity\t26\n" +
                "app\t26\n" +
                "deep\t26";
        String[] split = s.split("\\n");
        for (String s1 : split) {
            String[] split1 = s1.split("\\t");
            for(int i = 0 ; i < Integer.parseInt(split1[1])/4 ; i++) {
                System.out.println(split1[0]);
            }
        }
    }
}