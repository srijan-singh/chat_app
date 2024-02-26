package weekend.project.chat_app.component;

import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
public class CustomInfoContributor implements InfoContributor {

	@Override
	public void contribute(Builder builder) {
		builder.withDetail("custom", "Demo to implement gradle-git-properties on Spring-Boot using actuators.");
	}

}
