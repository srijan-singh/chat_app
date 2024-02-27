package weekend.project.chat_app.component;

import org.springframework.boot.actuate.info.Info.Builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
public class CustomInfoContributor implements InfoContributor {

	@Autowired
	private Git git;

	@Override
	public void contribute(Builder builder) {
		builder.withDetail("Demo", "Demo to fecth git-properties on Spring-Boot using builder.withDetails() method.");

		builder.withDetails(git.getAllProperties());
		
	}

}
