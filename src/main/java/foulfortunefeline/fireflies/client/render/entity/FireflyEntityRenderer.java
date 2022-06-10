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
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3f;
import org.jetbrains.annotations.NotNull;

public class FireflyEntityRenderer extends EntityRenderer<FireflyEntity> {
	protected FireflyEntityModel<FireflyEntity> model;

	public FireflyEntityRenderer(EntityRendererFactory.Context context) {
		super(context);
		model = new FireflyEntityModel<>(context.getPart(ModEntityModels.MODEL_FIREFLY_LAYER));
	}

	@Override
	public void render(@NotNull FireflyEntity entity, float yaw, float tickDelta, @NotNull MatrixStack matrices,
					   @NotNull VertexConsumerProvider vertexConsumers, int light) {
		matrices.push();

		matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(180F - entity.getYaw(tickDelta)));
		float color = Math.min(entity.getBrightness(), 10) / 20f + .5f;
		model.render(matrices, vertexConsumers.getBuffer(model.getLayer(getTexture(entity))), light, OverlayTexture.DEFAULT_UV,
				color, color, color, 1.0f);
		matrices.pop();
		super.render(entity, yaw, tickDelta, matrices, vertexConsumers, light);
	}

	@Override
	public Identifier getTexture(FireflyEntity entity) {
		return new Identifier(Fireflies.MODID, "textures/entity/firefly.png");
	}

	@Override
	protected int getBlockLight(FireflyEntity entity, BlockPos pos) {
		return Math.max(entity.getBrightness(), super.getBlockLight(entity, pos));
	}
}
