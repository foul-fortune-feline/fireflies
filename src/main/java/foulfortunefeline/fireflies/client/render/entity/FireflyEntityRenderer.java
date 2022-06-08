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

package foulfortunefeline.fireflies.client.render.entity;

import foulfortunefeline.fireflies.Fireflies;
import foulfortunefeline.fireflies.client.render.entity.model.FireflyEntityModel;
import foulfortunefeline.fireflies.client.render.entity.model.ModEntityModels;
import foulfortunefeline.fireflies.entities.FireflyEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class FireflyEntityRenderer extends LivingEntityRenderer<FireflyEntity, FireflyEntityModel<FireflyEntity>> {
	public FireflyEntityRenderer(EntityRendererFactory.Context context) {
		super(context, new FireflyEntityModel<>(context.getPart(ModEntityModels.MODEL_FIREFLY_LAYER)), 0f);
	}

	@Override
	public Identifier getTexture(FireflyEntity entity) {
		return new Identifier(Fireflies.MODID, "textures/entity/firefly.png");
	}

	@Override
	protected int getBlockLight(FireflyEntity entity, BlockPos pos) {
		return 15;
	}
}
