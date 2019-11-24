/**
 * FUNCTION Javascript to confirm Delete
 */
 function ConfirmDelete() {
     if ( confirm( "Êtes-vous sûr de vouloir supprimer cette utilisateur ?" ) ) {
        // Nothing here -> alert("Suppression effectuée !");
       return true;
     } else {
       alert("La suppression à été annulée !");
       return false;
     }
}
