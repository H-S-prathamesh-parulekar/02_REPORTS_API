package in.prathamesh.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import in.prathamesh.EligibilityDetailsRepo;
import in.prathamesh.entity.EligibilityDetails;

@Component
public class AppRunner implements ApplicationRunner {

	
	@Autowired
	private EligibilityDetailsRepo repo;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		EligibilityDetails entity1 = new EligibilityDetails();
		entity1.setEligId(1);
		entity1.setName("OOOOO");
		entity1.setMobile(9518562995l);
		entity1.setGender('M');
		entity1.setSsn(545464l);
		entity1.setPlanName("SNAP");
		entity1.setPlanStatus("Approved");
		
		repo.save(entity1);
		
		
		EligibilityDetails entity2 = new EligibilityDetails();
		entity2.setEligId(2);
		entity2.setName("sham");
		entity2.setMobile(888854l);
		entity2.setGender('M');
		entity2.setSsn(4646464l);
		entity2.setPlanName("vvdd");
		entity2.setPlanStatus("Approved");
		
		repo.save(entity2);
		
		
		
		
		
	}

}
