# QrGlide
如何使用:
Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.billdizl:QrGlide:0.1'
	}
  项目中已经为你添加glide依赖:  compile 'com.github.bumptech.glide:glide:3.7.0'

代码中使用:
  Bitmap bmp = BitmapFactory.decodeResource(getResources(),R.drawable.ic );
                Glide.with(MainActivity.this).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1531282493149&di=119a6d4981a316ed9b97e7a3136b8150&imgtype=0&src=http%3A%2F%2Fpic.58pic.com%2F58pic%2F15%2F23%2F09%2F74T58PICZjg_1024.jpg")                        .asBitmap()
                        .fitCenter()
                        .centerCrop()
                        .transform(new CenterCrop(MainActivity.this),new QRcenterTransformation(MainActivity.this,true,bmp))
                        //.skipMemoryCache(true) // 不使用内存缓存
                        .diskCacheStrategy(DiskCacheStrategy.SOURCE) // 不使用磁盘缓存
                        .into(hecheng);
