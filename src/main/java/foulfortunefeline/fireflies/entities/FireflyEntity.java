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
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.AmbientEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class FireflyEntity extends AmbientEntity {
	private static final double MIN_SPEED = 0.05d;
	private static final double MAX_SPEED = 0.2d;
	private static final float ACCELERATION = 0.02f;
	private static final double VERT_SPEED_SCALE = 0.5d;

	protected int flashTicks = 0;

	protected FireflyEntity(EntityType<? extends AmbientEntity> entityType, World world) {
		super(entityType, world);
	}


	@Override
	public void baseTick() {
		super.baseTick();

		tickFlash();
		Vec3d curVelocity = getVelocity();
		Vec3d newVelocity = clampVelocity(curVelocity.add(
				MathHelper.nextGaussian(world.getRandom(), 0.0f, ACCELERATION),
				MathHelper.nextGaussian(world.getRandom(), 0.0f, ACCELERATION),
				MathHelper.nextGaussian(world.getRandom(), 0.0f, ACCELERATION))
				.multiply(1.0d, VERT_SPEED_SCALE, 1.0d));
		setVelocity(newVelocity);

		setYaw(-((float)MathHelper.atan2(newVelocity.x, newVelocity.z)) * 180.0F / (float)Math.PI);

	}

	private static Vec3d clampVelocity(Vec3d inputVector) {
		double curSpeed = inputVector.length();
		if (curSpeed < MIN_SPEED) {
			return inputVector.multiply(MIN_SPEED / curSpeed);
		}
		if (curSpeed > MAX_SPEED) {
			return inputVector.multiply(MAX_SPEED / curSpeed);
		}
		return inputVector;
	}

	protected void tickFlash() {
		flashTicks--;
		if (flashTicks > 0) {
			return;
		}

		if (flashTicks < -20 && MathHelper.nextInt(world.random, -flashTicks - 20, 100) >= 95) {
			flashTicks = 20;
		}
	}

	public int getBrightness() {
		if (flashTicks <= 0) {
			return 0;
		}
		return Math.min(flashTicks, 15);
	}

	@Override
	public void writeCustomDataToNbt(NbtCompound nbt) {
		nbt.putInt("flashTicks", flashTicks);
		super.writeCustomDataToNbt(nbt);
	}

	@Override
	public void readCustomDataFromNbt(NbtCompound nbt) {
		flashTicks = nbt.getInt("flashTicks");
		super.readCustomDataFromNbt(nbt);
	}

	@Override
	public boolean handleFallDamage(float fallDistance, float damageMultiplier, DamageSource damageSource) {
		return false;
	}

	@Override
	protected void fall(double heightDifference, boolean onGround, BlockState landedState, BlockPos landedPosition) {
	}

	@Override
	public boolean isPushable() {
		return false;
	}

	@Override
	protected void pushAway(Entity entity) {
	}

	@Override
	public boolean hasNoGravity() {
		return true;
	}

	@Override
	protected float getActiveEyeHeight(EntityPose pose, EntityDimensions dimensions) {
		return dimensions.height / 2.0f;
	}

	@Override
	protected void playStepSound(BlockPos pos, BlockState state) {
	}

	@Override
	protected void playSwimSound(float volume) {
	}
}
