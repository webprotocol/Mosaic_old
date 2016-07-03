package com.hybrid;

import org.springframework.context.ApplicationContext;

import com.gluonhq.ignite.spring.SpringContext;
import com.gluonhq.particle.application.Particle;
import com.gluonhq.particle.application.ParticleApplication;

public class Global {
	public static ParticleApplication main;
	public static Particle particle;
	public static SpringContext sprintCtx;
	public static ApplicationContext ctx;
}
