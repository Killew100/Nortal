'use strict';

import gulp from 'gulp';
import gulpLoadPlugins from 'gulp-load-plugins';
import browserSync from 'browser-sync';
import del from 'del';
import { stream as wiredep } from 'wiredep';

var config = require('./build.config');

const $ = gulpLoadPlugins();
const reload = browserSync.reload;

gulp.task('styles', () => {
	return gulp.src('app/styles/main.scss')
		.pipe($.plumber())
		.pipe($.sourcemaps.init())
		.pipe($.sass.sync({
			outputStyle: 'expanded',
			precision: 10,
			includePaths: ['.']
		}).on('error', $.sass.logError))
		.pipe($.autoprefixer({ browsers: ['> 1%', 'last 2 versions', 'Firefox ESR'] }))
		.pipe($.sourcemaps.write())
		.pipe($.rename('app.css'))
		.pipe(gulp.dest('./app/dist'))
		.pipe($.cssnano())
		.pipe($.rename({ suffix: '.min' }))
		.pipe($.sourcemaps.write('.'))
		.pipe(gulp.dest('./app/dist'))
		.pipe(reload({ stream: true }));
});

gulp.task('scripts', () => {
	return gulp.src(config.js)
		//.pipe($.plumber())
		.pipe($.sourcemaps.init())
		//.pipe($.babel())
		.pipe($.concat('app.js'))
		.pipe(gulp.dest('./app/dist'))
		.pipe($.uglify())
		.pipe($.rename({ suffix: '.min' }))
		.pipe($.sourcemaps.write('.'))
		.pipe(gulp.dest('./app/dist'))
		.pipe(reload({ stream: true }));
});

gulp.task('serve', ['styles', 'scripts'], () => {
	browserSync({
		port: 7357,
		server: {
			baseDir: ['app']
		}
	});

	gulp.watch('app/styles/**/*.scss', ['styles']);
	gulp.watch(config.js, ['scripts']);
	gulp.watch('app/**/*.html').on('change', reload);

	console.log('App started');
});

gulp.task('build', ['styles', 'scripts'], () => {});
/**
 *	Default task executes serve task
 */
gulp.task('default', ['serve']);

