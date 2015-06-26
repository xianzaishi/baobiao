/*
Copyright (c) 2003-2012, CKSource - Frederico Knabben. All rights reserved.
For licensing, see LICENSE.html or http://ckeditor.com/license
*/

CKEDITOR.editorConfig = function( config )
{
	var uploadImageUrl = "/testSpring/cms/content/uploadImageUrl";
	// Define changes to default configuration here. For example:
	// config.language = 'fr';
	// config.uiColor = '#AADC6E';
	config.width = 700;
	config.height = 300;
	
	 config.toolbar_Full = [
		['Bold','Italic','Underline','Strike','-','Subscript','Superscript'],
		['BulletedList','Outdent','Indent','Blockquote'],
		['JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock'],
		['addpic','Table','Smiley','SpecialChar'],
		'/',
		['TextColor','BGColor'],
		['Styles','Format','Font','FontSize']
	];
	 
	 config.extraPlugins = 'addpic';
	 
	//默认的字体名 plugins/font/plugin.js
	config.font_defaultLabel = '宋体';
	
	//字体编辑时的字符集 可以添加常用的中文字符：宋体、楷体、黑体等 plugins/font/plugin.js
	config.font_names = 'Arial;Times New Roman;Verdana;宋体;楷体;黑体';
	
	//文字的默认式样 plugins/font/plugin.js
	config.font_style = {
	    element   : 'span',
	    styles   : { 'font-family' : '#(family)' },
	    overrides : [ { element : 'font', attributes : { 'face' : null } } ]
	};
	
	//字体默认大小 plugins/font/plugin.js
	config.fontSize_defaultLabel = '12px';
	
	//字体编辑时可选的字体大小 plugins/font/plugin.js
	config.fontSize_sizes ='8/8px;9/9px;10/10px;11/11px;12/12px;14/14px;16/16px;18/18px;20/20px;22/22px;24/24px;26/26px;28/28px;36/36px;48/48px;72/72px'
	
	//设置字体大小时 使用的式样 plugins/font/plugin.js
	config.fontSize_style = {
	    element   : 'span',
	    styles   : { 'font-size' : '#(size)' },
	    overrides : [ { element : 'font', attributes : { 'size' : null } } ]
	};
};
