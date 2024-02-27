package weekend.project.chat_app.component;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = "classpath:git.properties")
public class Git {

    @Value("${git.commit.id.abbrev}")
	private String commitId;

	@Value("${git.commit.time}")
	private String commitTime;

	@Value("${git.commit.message.short}")
	private String commitMessageShort;

	@Value("${git.branch}")
	private String branch;

	@Value("{git.total.commit.count=16}")
	private String totalCommitCount;


	public Map<String, Object> getAllProperties(){
		
		Map<String, Object> gitProperties = new HashMap<String, Object>();

		gitProperties.put("Commit ID", commitId);
		gitProperties.put("Commit Time: ", commitTime);
		gitProperties.put("Commit Message Short: ", commitMessageShort);
		gitProperties.put("Branch:", branch);
		gitProperties.put("Total Commit Count:", totalCommitCount);


	return gitProperties;
}

	

}
