$(function() {
	excel.init();
});

var excel = (function(){
	var inpt = $('<input type="text" value=""/>');
	var saveAndExit = function(){
		var val = $(this).attr('value');
		$(this).parent().text(val);
		$(this).remove();
	};
	var enableEditing = function(event){
		if($(this).find('input').length<1){
			var inpt1 = inpt.clone();
			inpt1.attr('value',$(this).text());
			$(this).html(inpt1);
			inpt1.focus();
			inpt1.width($(this).width()-2);
			$(inpt1).focusout(saveAndExit);
			inpt1.keyup(function(e){
				if(e.keyCode=='13'){
					saveAndExit.call(inpt1);
				}
			});
		}
		$('td').removeClass('selected');
		$(this).addClass('selected');
	};
	var initFormattingButtons = function(){
		$('#bold').on('click',function(){
			$('.selected').toggleClass('bold');
		});
		$('#italic').on('click',function(){
			$('.selected').toggleClass('italic');
		});
		$('#underline').on('click',function(){
			$('.selected').toggleClass('underline');
		});
	};
	var re_number_rows = function(){
		$('#mainTable tr td:first-child').each(function(i, el){
			$(el).text(i+1);
		});
	};
	var addRow = function(){
		var number = prompt("Enter the postion(number) after which new row has to be inserted");
		number=parseInt(number,10);
		if(number>=1){
			var row = $('#mainTable tr').get(0);
			var row_clone = $(row).clone();
			row_clone.find('th').replaceWith('<td></td>');
			row_clone.find('td:first-child').text(number+1);
			row_clone.insertAfter($('#mainTable tr').get(number));
			re_number_rows();
		}
	};
	var addColumn = function(){
		var alpha = prompt("Enter the alphabet of column after which new one has to be inserted");
		var resolved_index = undefined;
		var last_letter = 'A';
		if(alpha!=''){
			last_letter = $('th').each(function(i ,el){
				if($(el).text()==alpha){
					resolved_index = i;
				}
			}).last().text();
			
			if(resolved_index !== undefined){
				$('thead tr:first-child').append('<th></th>');
				$('tr').each(function(i,el){
					$('<td></td>').insertAfter($(el).find('td').get(resolved_index));
				});
				var code = last_letter.charCodeAt(0)+1;
				var letter = String.fromCharCode(code);
				if(last_letter == 'A')letter=last_letter;
				$('th:last-child').text(letter);
			}
		}
	};
	var removeRow = function(){
		var number = prompt("Enter the number of row to be removed");
		var removed = false;
		$('td:first-child').each(function(i, el){
			if(i>0){
				if(number==$(el).text()){
					$(el).parent().remove();
					removed =true;
				}
				if(removed){
					$(el).text(i);
				}
			}
		});
	};
	var removeColumn = function(){
		var alpha = prompt("Enter the alphabet of column to be removed");
		var resolved_index = undefined;
		if(alpha!=''){
			$('th').each(function(i ,el){
				if($(el).text()==alpha){
					resolved_index = i;
				}
			}).last().remove();
			if(resolved_index !== undefined){
				$('tr').each(function(i,el){
					if(i>0){
						$($(el).find('td').get(resolved_index)).remove();
					}
				});
			}
		}
	};
	var initTableEditing = function(){
		$('#mainContainer').on('click', '#addRows', addRow);
		$('#mainContainer').on('click', '#addColumns', addColumn);
		$('#mainContainer').on('click', '#removeRows', removeRow);
		$('#mainContainer').on('click', '#removeColumns',removeColumn);
	};
	var sortTable = function(ev){
		if(! $(ev.target).hasClass('sorted')){
			$('th').removeClass('sorted');
			$(ev.target).addClass('sorted');
			var ind = $('th').index(ev.target);
			var table_rows = [];
			$('tbody tr').each(function(i,el){
				table_rows.push($(el));
			});
			
			table_rows.sort(function(row1, row2){
				var a = $(row1.find('td').get(ind)).text();
				var b = $(row2.find('td').get(ind)).text();
				if(a==b){
					return 0;
				}else if(a>b){
					return 5;
				}else{
					return -6;
				}
			});
			$('tbody').empty();
			$.each(table_rows, function(i,el){
				$('tbody').append($(el));
			});
			re_number_rows();
		}else{
			alert('already sorted!');
		}
	};
	return{
		init:function(){
			$('#mainTable').on('click','td:not(:first-child)',enableEditing);
			initFormattingButtons();
			initTableEditing();
			$('#mainTable').on('click','th:not(:first-child)',sortTable);
		}
	};
}());