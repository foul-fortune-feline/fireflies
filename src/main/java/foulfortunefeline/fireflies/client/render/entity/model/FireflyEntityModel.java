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

import foulfortunefeline.fireflies.entities.FireflyEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;

public class FireflyEntityModel<T extends FireflyEntity> extends SinglePartEntityModel<T> {
	private final ModelPart root;

	public FireflyEntityModel(ModelPart modelPart) {
		this.root = modelPart.getChild(EntityModelPartNames.BODY);
	}


	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		modelPartData.addChild(EntityModelPartNames.BODY, ModelPartBuilder.create().uv(0, 0)
						.cuboid(-0.25F, 23F, -0.5F, 0.5F, 0.5F, 1.0F), ModelTransform.NONE
		);
		return TexturedModelData.of(modelData, 3, 2);
	}

	@Override
	public ModelPart getPart() { return root; }

	@Override
	public void setAngles(FireflyEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
	}
}
