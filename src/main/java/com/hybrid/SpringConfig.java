package com.hybrid;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gluonhq.particle.application.Particle;
import com.gluonhq.particle.application.ParticleApplication;
import com.gluonhq.particle.form.FormManager;
import com.gluonhq.particle.view.ViewManager;
import com.hybrid.service.Service;

@Configuration
class SpringConfig  {
	public SpringConfig() {
		System.out.println("SpringConfig()...");
	}
	
	@Bean
	public Service provideService() {
		System.out.println("provideService()...");
		return new Service();
	}
	
	@Bean
	public ParticleApplication provideParticleApplication() {
		System.out.println("provideParticleApplication()...");
		return Global.main;
	}

	@Bean
	public Particle provideParticle() {
		System.out.println("provideParticle()...");
		return Global.particle;
	}
	
	@Bean
	public ViewManager provideViewManager() {
		System.out.println("provideViewManager()...");
		return Global.particle.getViewManager();
	}

	@Bean
	public FormManager provideFormManager() {
		System.out.println("provideFormManager()...");
		return Global.particle.getFormManager();
	}
	
}