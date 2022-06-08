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

package foulfortunefeline.fireflies.entities;

import foulfortunefeline.fireflies.Fireflies;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEntities {
	public static final EntityType<FireflyEntity> FIREFLY = Registry.register(
			Registry.ENTITY_TYPE,
			new Identifier(Fireflies.MODID, "firefly"),
			FabricEntityTypeBuilder.create(SpawnGroup.AMBIENT, FireflyEntity::new)
					.dimensions(EntityDimensions.fixed(0.1f, 0.1f)).build()
	);


	public static void registerEntities() {
		FabricDefaultAttributeRegistry.register(FIREFLY, FireflyEntity.createMobAttributes()
				.add(EntityAttributes.GENERIC_MAX_HEALTH, 1)
				.add(EntityAttributes.GENERIC_FLYING_SPEED, 5));
	}
}
