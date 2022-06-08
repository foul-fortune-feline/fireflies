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

package foulfortunefeline.fireflies.client.render.entity.model;

import foulfortunefeline.fireflies.Fireflies;
import foulfortunefeline.fireflies.client.render.entity.FireflyEntityRenderer;
import foulfortunefeline.fireflies.entities.ModEntities;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModEntityModels {
	public static final EntityModelLayer MODEL_FIREFLY_LAYER =
			new EntityModelLayer(new Identifier(Fireflies.MODID, "firefly"), "main");

	public static void registerEntityModels() {
		EntityRendererRegistry.register(ModEntities.FIREFLY, FireflyEntityRenderer::new);

		EntityModelLayerRegistry.registerModelLayer(MODEL_FIREFLY_LAYER, FireflyEntityModel::getTexturedModelData);
	}
}
