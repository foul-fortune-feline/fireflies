/*
 * A modification for minecraft using the quilt toolchain, adding fireflies and related items
 * Copyright (C) 2022  Lucianna Osucha
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package foulfortunefeline.fireflies;

import foulfortunefeline.fireflies.entities.ModEntities;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class Fireflies implements ModInitializer {
	public static final String MODID = "fireflies";
	public static final Logger LOGGER = LoggerFactory.getLogger("Fireflies");
	public static final Random RANDOM = new Random(System.currentTimeMillis());

	@Override
	public void onInitialize(ModContainer mod) {
		LOGGER.info("Initializing {}...", mod.metadata().name());

		ModEntities.registerEntities();
	}
}
