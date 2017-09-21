/***************************/
//@Author: Adrian "yEnS" Mato Gondelle & Ivan Guardado Castro
//@website: www.yensdesign.com
//@email: yensamg@gmail.com
//@license: Feel free to use it, but keep this credits please!					
/***************************/

$(document).ready(function(){
	$("#divJenisBaru").hide();
	$("#divSatuanBaru").hide();
	$("#divKeteranganBaru").hide();
					
	$('#jenis').change( 
			function(){
				if($('#jenis option:selected').val()==-1){
					$("#divJenisBaru").show("normal");
					$("#divSatuanBaru").show("normal");
					$("#divKeteranganBaru").show("normal");
					
				}else{
					$('#divJenisBaru').hide("normal");
					$("#divSatuanBaru").hide("normal");
					$("#divKeteranganBaru").hide("normal");
					
				}

			}
	   );

	//global vars
	var form = $("#customForm");
	var name = $("#nomorTransaksi");
	var nameInfo = $("#nomorTransaksiInfo");
	
	var nilai = $("#nilai");
	var nilaiInfo = $("#nilaiInfo");
	
	var satuanBaru = $("#satuanBaru");
	var satuanBaruInfo = $("#satuanBaruInfo");
	
	var jenisBaru = $("#jenisBaru");
	var jenisBaruInfo = $("#jenisBaruInfo");
	
	//On blur
	name.blur(validateNomorTransaksi);
	nilai.blur(validateNumber);
	jenisBaru.blur(validateJenisBaru);
	satuanBaru.blur(validateSatuanBaru);
	//On key press
	name.keyup(validateNomorTransaksi);
	nilai.keyup(validateNumber);
	jenisBaru.keyup(validateJenisBaru);
	satuanBaru.keyup(validateSatuanBaru);
	//On Submitting
	form.submit(function(){
		if($('#jenis option:selected').val()==-1){

			if(validateJenisBaru() & validateSatuanBaru() & validateNumber() & validateNomorTransaksi())
				return true;
			else
				return false;
		}else{
			if(validateNumber() & validateNomorTransaksi())
				return true;
			else
				return false;
		}
	});
	
	//validation functions
	function validateNomorTransaksi(){
		//if it's NOT valid
		if(name.val().length == 0){
			name.addClass("error");
			nameInfo.text("harus diisi!");
			nameInfo.addClass("error");
			return false;
		}
		//if it's valid
		else{
			name.removeClass("error");
			nameInfo.text("OK");
			nameInfo.removeClass("error");
			return true;
		}
	}
	function validateJenisBaru(){
		//if it's NOT valid
		if(jenisBaru.val().length == 0){
			jenisBaru.addClass("error");
			jenisBaruInfo.text("harus diisi!");
			jenisBaruInfo.addClass("error");
			return false;
		}
		//if it's valid
		else{
			jenisBaru.removeClass("error");
			jenisBaruInfo.text("OK");
			jenisBaruInfo.removeClass("error");
			return true;
		}
	}
	
	function validateSatuanBaru(){
		//if it's NOT valid
		if(satuanBaru.val().length == 0){
			satuanBaru.addClass("error");
			satuanBaruInfo.text("harus diisi!");
			satuanBaruInfo.addClass("error");
			return false;
		}
		//if it's valid
		else{
			satuanBaru.removeClass("error");
			satuanBaruInfo.text("OK");
			satuanBaruInfo.removeClass("error");
			return true;
		}
	}
	function validateNumber(){
		if(nilai.val().length==0){
			nilai.addClass("error");
			nilaiInfo.text("harus diisi!");
			nilaiInfo.addClass("error");
			return false;
		}else{
			if(isNaN(nilai.val())){
				nilai.addClass("error");
				nilaiInfo.text("Salah, masukkan angka!");
				nilaiInfo.addClass("error");
				return false;
			}else{
				nilai.removeClass("error");
				nilaiInfo.text("OK");
				nilaiInfo.removeClass("error");
				return true;
			}
		}
		
	}


});