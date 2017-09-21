<?php
    $mysqli = new mysqli("localhost","root","","muharram");
    
    $select_uang = "SELECT SUM(A.jumlah) AS jumlah,B.satuan FROM tr_shodaqoh A LEFT JOIN ms_shodaqoh B
                    ON A.shodaqoh = B.id_shodaqoh WHERE B.jenis = 'Uang'  AND tahun = (SELECT tahun FROM tahun_aktif where status = 1) GROUP BY B.satuan";
    $result_uang = $mysqli->query($select_uang);
    $data = array();
    while($row = $result_uang->fetch_array()){
        $data['uang'][] = array('jumlah'=>$row['jumlah'],'satuan'=>$row['satuan']);
    }
    
    $select_barang = "SELECT SUM(CAST(A.jumlah AS SIGNED)) AS jumlah,B.satuan,B.jenis FROM tr_shodaqoh A LEFT JOIN ms_shodaqoh B
            ON A.shodaqoh = B.id_shodaqoh WHERE B.jenis <> 'Uang' AND tahun = (SELECT tahun FROM tahun_aktif where status = 1)  GROUP BY B.satuan,B.jenis";
    $result_barang = $mysqli->query($select_barang);
    while($row=$result_barang->fetch_array()){
        $data['barang'][]= array('jenis'=>$row['jenis'],'jumlah'=>$row['jumlah'],'satuan'=>$row['satuan']);
    }
    
    $select_total = "select sum(jumlah*D.nominal) total from
            (select satuan,sum(jumlah) jumlah from tr_shodaqoh A
            left join ms_shodaqoh B
            ON A.shodaqoh = B.id_shodaqoh
            where B.jenis = 'Uang' AND tahun = (SELECT tahun FROM tahun_aktif where status = 1)
            group by shodaqoh) C
            LEFT JOIN kurs D ON C.satuan = D.id_kurs";
    $result_total = $mysqli->query($select_total);
    $row = $result_total->fetch_array();;
    $data['total']= $row['total'];
    echo json_encode($data);
    
?>
